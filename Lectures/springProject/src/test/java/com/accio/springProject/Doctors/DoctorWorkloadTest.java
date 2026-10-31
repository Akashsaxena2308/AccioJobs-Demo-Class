package com.accio.springProject.Doctors;

import com.accio.springProject.Doctors.Controller.DoctorController;
import com.accio.springProject.Doctors.Exception.DoctorNotFoundException;
import com.accio.springProject.Doctors.Exception.PatientNotFoundException;
import com.accio.springProject.Doctors.Model.DoctorWorkload;
import com.accio.springProject.Doctors.Model.RebalanceResult;
import com.accio.springProject.Doctors.Repository.DoctorRepository;
import com.accio.springProject.Doctors.Service.DoctorService;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import static org.junit.jupiter.api.Assertions.*;

class DoctorWorkloadTest {
    private EmbeddedDatabase database;
    private JdbcTemplate jdbc;
    private DoctorRepository repository;
    private DoctorService service;

    @BeforeEach
    void setUp() {
        database = new EmbeddedDatabaseBuilder().generateUniqueName(true)
                .setType(EmbeddedDatabaseType.H2).addScript("schema.sql").build();
        jdbc = new JdbcTemplate(database);
        repository = new DoctorRepository(jdbc);
        service = new DoctorService(repository);
    }

    @AfterEach
    void close() { database.shutdown(); }

    private void doctor(long id) {
        jdbc.update("INSERT INTO doctors (id, name) VALUES (?, ?)", id, "Doctor " + id);
    }

    private void patient(long id, Long doctorId) {
        jdbc.update("INSERT INTO patients (id, name, age, doctor_id) VALUES (?, ?, ?, ?)",
                id, "Patient " + id, 25, doctorId);
    }

    private void noMove(RebalanceResult result) {
        assertFalse(result.isMoved());
        assertNotNull(result.getMessage());
        assertNull(result.getPatientId());
        assertNull(result.getFromDoctorId());
        assertNull(result.getToDoctorId());
    }

    @Test
    void emptyAndSingleDoctorDoNotMove() {
        assertTrue(service.getWorkload().isEmpty());
        noMove(service.rebalance());
        doctor(8);
        patient(100, 8L);
        noMove(service.rebalance());
        assertEquals(1, service.getWorkload().get(0).getPatientCount());
    }

    @Test
    void zeroWorkloadsIncludeAllDoctorsAndUseAscendingIds() {
        doctor(9); doctor(2); doctor(5);
        List<DoctorWorkload> result = service.getWorkload();
        assertEquals(List.of(2L, 5L, 9L), result.stream().map(DoctorWorkload::getDoctorId).toList());
        assertTrue(result.stream().allMatch(w -> w.getPatientCount() == 0));
        noMove(service.rebalance());
    }

    @Test
    void oneStepMovesLowestSourcePatientAndIgnoresUnassigned() {
        doctor(1); doctor(2); doctor(3);
        for (long id : new long[]{50, 10, 40, 20, 30}) patient(id, 1L);
        patient(60, 2L);
        patient(5, null);
        assertEquals(List.of(5, 1, 0), service.getWorkload().stream().map(DoctorWorkload::getPatientCount).toList());
        RebalanceResult moved = service.rebalance();
        assertTrue(moved.isMoved());
        assertEquals(10L, moved.getPatientId());
        assertEquals(1L, moved.getFromDoctorId());
        assertEquals(3L, moved.getToDoctorId());
        assertEquals(List.of(4, 1, 1), service.getWorkload().stream().map(DoctorWorkload::getPatientCount).toList());
        assertEquals(6, service.getWorkload().stream().mapToInt(DoctorWorkload::getPatientCount).sum());
        assertNull(jdbc.queryForObject("SELECT doctor_id FROM patients WHERE id = 5", Long.class));
        assertEquals(3L, jdbc.queryForObject("SELECT doctor_id FROM patients WHERE id = 10", Long.class));
        // Report calls must not move another patient.
        service.getWorkload();
        assertEquals(4, repository.findPatientsByDoctorId(1).size());
    }

    @Test
    void bothDoctorTiesChooseLowestIdRatherThanLastReportEntry() {
        doctor(4); doctor(3); doctor(2); doctor(1);
        patient(30, 1L); patient(10, 1L);
        patient(20, 2L); patient(40, 2L);
        assertEquals(List.of(1L, 2L, 3L, 4L), service.getWorkload().stream().map(DoctorWorkload::getDoctorId).toList());
        RebalanceResult result = service.rebalance();
        assertEquals(1L, result.getFromDoctorId());
        assertEquals(3L, result.getToDoctorId());
        assertEquals(10L, result.getPatientId());
    }

    @Test
    void gapOfOneDoesNotMove() {
        doctor(1); doctor(2);
        patient(1, 1L); patient(2, 1L); patient(3, 2L);
        noMove(service.rebalance());
        assertEquals(2, repository.findPatientsByDoctorId(1).size());
    }

    @Test
    void existingAssignmentRulesStayCorrectAndErrorsAre404() {
        doctor(1); doctor(2); patient(1, 1L);
        service.assign(1, 1); service.assign(1, 1);
        assertEquals(1, service.getPatients(1).size());
        assertThrows(DoctorNotFoundException.class, () -> service.assign(999, 1));
        assertThrows(PatientNotFoundException.class, () -> service.assign(2, 999));
        assertEquals(1, service.getPatients(1).size());
        DoctorController controller = new DoctorController(service);
        assertEquals(404, controller.assign(999, 1).getStatusCode().value());
        assertEquals(404, controller.assign(2, 999).getStatusCode().value());
        assertEquals(404, controller.getPatients(999).getStatusCode().value());
        service.assign(2, 1);
        assertTrue(service.getPatients(1).isEmpty());
        jdbc.update("UPDATE patients SET name = ? WHERE id = ?", "Changed", 1);
        assertEquals("Changed", service.getPatients(2).get(0).getName());
        jdbc.update("DELETE FROM patients WHERE id = 1");
        assertTrue(service.getPatients(2).isEmpty());
    }

    @Test
    void movedAssignmentSurvivesReopeningFileDatabase(@TempDir Path directory) {
        String url = "jdbc:h2:file:" + directory.resolve("doctor-workload").toAbsolutePath()
                .toString().replace('\\', '/') + ";DB_CLOSE_ON_EXIT=FALSE";
        DriverManagerDataSource first = new DriverManagerDataSource(url, "sa", "");
        new ResourceDatabasePopulator(new ClassPathResource("schema.sql")).execute(first);
        JdbcTemplate fileJdbc = new JdbcTemplate(first);
        fileJdbc.update("INSERT INTO doctors (id, name) VALUES (1, 'One'), (2, 'Two')");
        fileJdbc.update("INSERT INTO patients (id, name, age, doctor_id) VALUES (1, 'A', 25, 1), (2, 'B', 25, 1)");
        DoctorService firstService = new DoctorService(new DoctorRepository(fileJdbc));
        assertTrue(firstService.rebalance().isMoved());
        // DriverManagerDataSource connections close after each JdbcTemplate call;
        // a new datasource reads the persisted assignment, not a Java list.
        DoctorService reopened = new DoctorService(new DoctorRepository(new JdbcTemplate(
                new DriverManagerDataSource(url, "sa", ""))));
        assertEquals(1L, reopened.getPatients(2).get(0).getId());
        assertEquals(1, reopened.getPatients(1).size());
    }
}

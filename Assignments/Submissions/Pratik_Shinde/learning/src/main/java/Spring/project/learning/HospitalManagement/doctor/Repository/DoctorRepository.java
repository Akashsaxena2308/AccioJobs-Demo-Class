package Spring.project.learning.HospitalManagement.doctor.Repository;


import Spring.project.learning.HospitalManagement.doctor.Entity.Doctor;
import Spring.project.learning.HospitalManagement.doctor.Model.DoctorInput;
import Spring.project.learning.HospitalManagement.patient.Entity.Patient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoctorRepository {
    private final JdbcTemplate jdbc;

    public DoctorRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    private final RowMapper<Doctor> doctorRowMapper =
            (rs, rowNum) ->
                    new Doctor(rs.getLong("id"), rs.getString("name"));

    private final RowMapper<Patient> patientRowMapper = (rs, rowNum) ->
            new Patient(rs.getLong("id"), rs.getString("name"), rs.getInt("age"));

    public List<Doctor> findAll(){
        return jdbc.query("SELECT * FROM Doctors", doctorRowMapper);
    }

    public List<Patient> findPatient(Long doctor_id){
        return jdbc.query("SELECT * FROM patients WHERE doctor_id = ?", patientRowMapper, doctor_id);
    }

    public void add(DoctorInput doctorInput){
        long id = jdbc.queryForObject("SELECT NEXT VALUE for doctors_id", Long.class);
        jdbc.update("INSERT INTO doctors (id, name) VALUES(?, ?)", id, doctorInput.getName());
    }

    public void assign(Long d_id, Long p_id){
        jdbc.update("UPDATE patients SET doctor_id = ? WHERE id = ?", patientRowMapper, d_id, p_id);
    }
}

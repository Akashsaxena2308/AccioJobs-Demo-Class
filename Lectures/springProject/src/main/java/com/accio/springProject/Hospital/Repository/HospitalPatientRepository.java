package com.accio.springProject.Hospital.Repository;

import com.accio.springProject.Hospital.Entity.Patient;
import com.accio.springProject.Hospital.Model.PatientInput;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HospitalPatientRepository {

    private final JdbcTemplate jdbc;

    public HospitalPatientRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;

    }

    private final RowMapper<Patient> patientMapper =
            (rs, rowNum) ->
                    new Patient(rs.getLong("id"), rs.getString("name"), rs.getInt("age"));

    public List<Patient> findAll() {
        return jdbc.query("SELECT id, name, age FROM patients ORDER BY id", patientMapper);
    }

    public void add(PatientInput patientInput) {
        jdbc.update("INSERT INTO patients ( name, age) VALUES ( ?, ?)", patientInput.getName(), patientInput.getAge());
    }

    public void updateName(long id, PatientInput input) {
        jdbc.update("UPDATE patients SET name = ? WHERE id = ?", input.getName(), id);
    }


    public boolean delete(long id) {
        int removedRows = jdbc.update("DELETE FROM patients WHERE id = ?", id);
        return removedRows > 0;
    }
}


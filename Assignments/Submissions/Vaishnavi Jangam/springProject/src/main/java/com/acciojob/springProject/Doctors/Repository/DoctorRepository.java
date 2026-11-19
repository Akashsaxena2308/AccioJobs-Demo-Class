package com.acciojob.springProject.Doctors.Repository;

import com.acciojob.springProject.Doctors.Model.Doctor;
import com.acciojob.springProject.HospitalManagement.Entity.Patient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public class DoctorRepository {
    private final JdbcTemplate jdbc;

    public DoctorRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private final RowMapper<Doctor> doctorRowMapper = (rs, rowNum)->
            new Doctor(rs.getLong("id"), rs.getString("name"));

    private final RowMapper<Patient> patientRowMapper = (rs, rowNum)->
            new Patient(rs.getLong("id"), rs.getString("name"), rs.getInt("age"));

    public Doctor findById(long id){
        List<Doctor> matches = jdbc.query("SELECT id, name FROM doctors WHERE id = ?", doctorRowMapper,  id);
        return matches.isEmpty() ? null : matches.get(0);
    }

    public List<Patient> findPatientsByDoctorId(long DoctorId){
        return jdbc.query("SELECT id, name, age FROM patients WHERE Doctor_id = ?", patientRowMapper, DoctorId);
    }

    public boolean assignPatients(long doctorId, long patientId){
        int changeRow = jdbc.update("Update patients SET doctor_id = ? WHERE id = ?", doctorId, patientId);
        return changeRow > 0;
    }

    public List<Doctor> findAll(){
        return jdbc.query("SELECT id, name FROM doctors ORDER BY id", doctorRowMapper);
    }
}

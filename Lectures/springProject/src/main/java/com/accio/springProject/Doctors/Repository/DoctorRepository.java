package com.accio.springProject.Doctors.Repository;

import com.accio.springProject.Doctors.Model.Doctor;
import com.accio.springProject.Hospital.Entity.Patient;
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

    private final RowMapper<Doctor> doctorRowMapper = (rs, rowNum) ->
        new Doctor(rs.getLong("id"), rs.getString("name"));

    private final RowMapper<Patient> patientRowMapper = (rs, rowNum) ->
            new Patient(rs.getLong("id"), rs.getString("name"), rs.getInt("age"));

    public Doctor findById(long id){
        List<Doctor> matches = jdbc.query("SELECT id, name FROM doctors WHERE id = ?", doctorRowMapper, id);

        return matches.isEmpty() ? null : matches.get(0);
    }

    public List<Patient> findPatientsByDoctorId(long doctorId){
        return jdbc.query("SELECT id, name, age FROM patients WHERE doctor_id = ? ORDER BY id", patientRowMapper, doctorId);
    }

    public boolean assignPatients(long doctorId, long patientId){
        int changedRow = jdbc.update("UPDATE patients SET doctor_id = ? WHERE id = ?", doctorId, patientId);

        return changedRow > 0;
    }


    public List<Doctor> findAll() {
        return jdbc.query("SELECT id, name FROM doctors ORDER BY id", doctorRowMapper);
    }

}
// Method --> return type --> Doctor


// Query --> Row return
// Helper method / function --> convert SQL row to Java object --> RowMapper
// Java --> Objects

//jdbc --> Java database connectivity --> Core library
// JDBCTemplate class --> method .query() --> runs a SQL query --> return type
// Doctor, List<Doctor>

// Doctor matches --> List<Doctor>
// []
//Repository --> Data handling --> Store / Retrieve / Update / Delete

//Start application --> Component scan --> Find all classes with stereotype annotation

// Create bean for these classes
//IoC container / Application context / Spring application context
//StereoType annotation --> Tells Spring to create object for these classes on startup

// Service object --- Repository Object
//

//Dependency -->
// Bean ---> Object -> Type --> Singleton
//
// Object1 --> needs object2
//
//class A{
//
//    A(B){
//
//    }
//}
//
//class B {
//
//}
//
//
//new A(new B());

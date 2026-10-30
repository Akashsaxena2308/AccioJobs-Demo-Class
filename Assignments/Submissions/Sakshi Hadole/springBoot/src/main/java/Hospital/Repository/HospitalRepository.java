package Hospital.Repository;

import Hospital.Entity.Patient;
import Hospital.Model.PatientInput;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HospitalRepository {
    private final JdbcTemplate jdbc;

    public HospitalRepository(JdbcTemplate jdbc){
        this.jdbc=jdbc;
    }
    private final RowMapper<Patient> patientRowMapper=((rs, rowNum) ->
            new Patient(rs.getLong("id"),rs.getString("name"),rs.getInt("age")));

    public List<Patient> findAll(){
        return jdbc.query("SELECT id,name,age FROM patients ORDER BY id",patientRowMapper);
    }
    public void add(PatientInput patientInput){
        long id=jdbc.queryForObject(
                "SELECT NEXT VALUE for patient_id",Long.class);

        jdbc.update(
                "INSERT INTO patients(id,name,age) VALUES(?,?,?)",id,patientInput.getName(),patientInput.getAge());
    }
    public void updateName(long id,PatientInput input){
        jdbc.update("UPDATE patients SET name=? WHERE id=?", input.getName(),id);
    }
    public boolean delete(long id){
        int removeRows=jdbc.update("DELETE FROM patients WHERE id=?",id);
        return removeRows>0;
    }
}

package Spring.project.learning.HospitalManagement.doctor.Model;

import Spring.project.learning.HospitalManagement.patient.Entity.Patient;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DoctorInput {

    @NotNull
    String name;

    List<Patient> patients = new ArrayList<>();

    public void setPatients(List<Patient> patient){
        this.patients = patient;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

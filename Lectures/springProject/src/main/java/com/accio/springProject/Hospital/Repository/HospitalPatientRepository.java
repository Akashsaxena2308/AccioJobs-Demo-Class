package com.accio.springProject.Hospital.Repository;

import com.accio.springProject.Hospital.Entity.Patient;
import com.accio.springProject.Hospital.Model.PatientInput;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HospitalPatientRepository {

    private final List<Patient> patients = new ArrayList<>();
    long id;

    public HospitalPatientRepository(){
        patients.add(new Patient(1, "Patient1" , 25));
        patients.add(new Patient(2,"Patient2", 32));
        id = 2;
    }

    public List<Patient> findAll(){
        return patients;
    }

    public void add(PatientInput patientInput){
        patients.add(new Patient(id+1, patientInput.getName(), patientInput.getAge()));
        id++;
    }

    public void updateName(long id, PatientInput input){
        for (Patient p : patients){
            if(p.getId() == id){
                p.setName(input.getName());
            }
        }
    }

    public boolean delete(long id){
        for(int index = 0; index< patients.size(); index++){
            if(patients.get(index).getId() == id){
                patients.remove(index);
                return true;
            }
        }

        return false;
    }
}

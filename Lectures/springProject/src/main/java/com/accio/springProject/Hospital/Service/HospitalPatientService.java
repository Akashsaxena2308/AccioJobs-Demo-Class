package com.accio.springProject.Hospital.Service;

import com.accio.springProject.Hospital.Entity.Patient;
import com.accio.springProject.Hospital.Model.PatientInput;
import com.accio.springProject.Hospital.Repository.HospitalPatientRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HospitalPatientService {

    private final HospitalPatientRepository repository;


    private static final Logger log =
            LoggerFactory.getLogger(HospitalPatientService.class);

    public HospitalPatientService(HospitalPatientRepository repository){
        this.repository = repository;
    }

    public List<Patient> getPatients(){
        log.info("Fetching hospital patients");
        List<Patient> patients = repository.findAll();
        log.debug("Fetched {} patient rows", patients.size());
        return patients;
    }

    public List<Patient> addPatient(PatientInput input){
        repository.add(input);
        return repository.findAll();
    }

    public List<Patient> updatePatient(long id, PatientInput input){
        repository.updateName(id, input);
        return  repository.findAll();
    }

    public boolean deletePatient(long id){
        return repository.delete(id);
    }

    public List<Patient> searchByName(String name){
        List<Patient> finalPatient = new ArrayList<>();

        for( Patient p : repository.findAll()){
            if(p.getName().equals(name)){
                finalPatient.add(p);
            }
        }

        return  finalPatient;
    }

    public List<Patient> getSortedBy(String param){
        List<Patient> patients = repository.findAll();

        if(param.equals("id")){
            patients.sort(
                    (p1, p2) ->
                            Long.compare(p1.getId(), p2.getId())
            );
        }
        else if(param.equals("name")){
            patients.sort(
                    (p1, p2) ->
                            p1.getName().compareTo(p2.getName())
            );
        }
        else {
            patients.sort(
                    (p1, p2) ->
                            Integer.compare((int)p1.getAge(), (int)p2.getAge())
            );
        }

        return patients;
    }
}

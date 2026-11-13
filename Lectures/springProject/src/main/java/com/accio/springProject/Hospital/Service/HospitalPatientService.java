package com.accio.springProject.Hospital.Service;

import com.accio.springProject.Hospital.Entity.Patient;
import com.accio.springProject.Hospital.Model.PatientInput;
import com.accio.springProject.Hospital.Repository.HospitalPatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HospitalPatientService {

    //Hospital Service --> Singleton --> Application --> same object will be user for HS
    //HS1 , HS2 --> log --> Same
    //static --> Same or shared between all objects

    private static final Logger log = LoggerFactory.getLogger(HospitalPatientService.class);

    private final HospitalPatientRepository repository;

    public HospitalPatientService(HospitalPatientRepository repository){
        this.repository = repository;
    }

    public List<Patient> getPatients(){
        log.info("Fetching hospital patients!");

        //Extra logic

        List<Patient> patients = repository.findAll();

        System.out.println("Checkpoint 1");

        log.debug("Fetched {} patient rows {}", patients.size(), patients.size());
        return patients;
    }

    //ERROR --> Failed operation; logging alone does not stop the application
    //WARN --> Unusual condition worth attention
    //INFO --> Normal operations --------> DEFAULT application level
    //DEBUG --> Debugging information needed to understand the application --> User
    //TRACE --> Very detailed execution

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


//Application --> Java Service


//Frontend --> API -->  Tomcat --> Dispatcher servlet --> Identify which controller and method will be called
// Controller --> java methods --> service --> repository ....


//Hospital Application -- Cab Service Application

// API --> REST API , SOAP , graphQL

// Internet communication --> REST API

// Rest client

// Third party application -- Java Application



//springProjectApplication
//Expose an endpoint to get task with a given id
// Todos --> Task list --> Id
// localhost:8081/todos/{id} --> Task details
//springProjectAPplication ---> API call --> Fake REST Jsonplaceholder service --> Task details --> We will use task details

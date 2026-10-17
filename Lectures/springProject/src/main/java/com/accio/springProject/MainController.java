package com.accio.springProject;

import org.springframework.expression.spel.ast.Literal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/commonpath")
public class MainController {

    private final List<Patient> patients = new ArrayList<>();
    long id;

    public MainController(){
        patients.add(new Patient(1, "Patient1" , 25));
        patients.add(new Patient(2,"Patient2", 32));
        id = 2;
    }

    //p1 - 1 - A
    //p3 - 3 - A
    //p4 - 4 - B
    //p5 - 5 - C

    //search

    //[{1 - A}, {2  - A}]


    @GetMapping("/search")
    public List<Patient> searchByName(@RequestParam() String name){
        List<Patient> finalPatient = new ArrayList<>();

        for( Patient p : patients){
            if(p.getName().equals(name)){
                finalPatient.add(p);
            }
        }

        return finalPatient;
    }


    //DELTET


    @GetMapping("/patients")
    public List<Patient> getPatients(){
        return patients;
    }


    //Hardcoded list
    //Get patients details from User
    //Add this patient to existing list]



    // url : localhost:8080/commonpath/addPatient
    // url : localhost:8080/commonpath/updatePatient
    // url : localhost:8080/commonpath/deletePatient
    // url : localhost:8080/commonpath/Patient


    //http::localhost:port/pathVariable/{pathVariable}?requestParam=Value


    //POST
    //User will provide the data

    //JSON
    //Converts this to Request Java Object
    @PostMapping("/addPatient")
    public List<Patient> addPatient(@RequestBody PatientInput patientInput){
        patients.add(new Patient(id+1, patientInput.name, patientInput.age));
        id++;
        return patients;
    }

    @PutMapping("/updatePatient/{id}")
    public List<Patient> updatePatient(@PathVariable long id, @RequestBody PatientInput input){
        for (Patient p : patients){
            if(p.getId() == id){
                p.setName(input.getName());
            }
        }

        return patients;
    }


    //No need to handle errors or exception --> Springboot

    //Business logic --> Creates an Exception --> 400 --> Bad Request --> patient does not exist

    //Response Entity

    //

//    ResponseEntity.ok() --> 200
    // ResponseEntity.badRequest().body("error") --> 400 + error
    // ResponseEntity.status(404).body("error") --> 404 + error

    @DeleteMapping("/deletePatients/{id}")
    public ResponseEntity<Object> deletePatient(@PathVariable long id){

        int flag = 0;
        for (Patient p : patients){
            if(p.getId() == id){
                patients.remove(p);
                flag = 1;
            }
        }

        if(flag == 0){
            return ResponseEntity.status(404).body("Patient not found!");
//            return
        }


        return  ResponseEntity.ok(patients);
    }

    @GetMapping("/browse")
    public List<Patient> getSortedBy(@RequestParam String param){
        if(param.equals("id")){
            patients.sort(
                    (p1, p2) ->
                        Integer.compare((int)p1.getId(), (int)p2.getId())
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

    //Controller
    // --> Exposes endpoints

    //Service

    //Repository

    //Implemention

    //Model

    //Entity

}

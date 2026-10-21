package com.accio.springProject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    private final List<Patient> patients = new ArrayList<>();
    int id;

    public MainController(){
        patients.add(new Patient("P1", 30, 1));
        patients.add(new Patient("P2", 50, 2));
        id = 2;
    }

    // get patients details
    @GetMapping("/patientDetails")
    public List<Patient> getDetails(){
        return patients;
    }

    // add patients
    @PostMapping("/addPatient")
    public List<Patient> addPatient(@RequestBody PatientInput pIP){
        patients.add(new Patient(pIP.name, pIP.age, id+1));
        id++;
        return patients;
    }

    //update patient details
    @PutMapping("/updatePatient/{id}")
    public List<Patient> updatePatient(@PathVariable int id, @RequestBody PatientInput pIp){

        for (Patient p : patients){
            if(p.id == id){
                p.name = pIp.name;
                p.age = pIp.age;
            }
        }

        return patients;
    }

    // delete Patient
    @DeleteMapping("/deletePatient/{id}")
    public ResponseEntity<Object> deletePatient(@PathVariable int id){

        boolean flag = false;
        for (Patient p : patients){
            if(id == p.id){
                patients.remove(p);
                flag = true;
            }
        }

        if(!flag){
            return ResponseEntity.status(404).body("Patient not found");
        }

        return ResponseEntity.ok(patients);
    }

    // same name patient details
    @GetMapping("/patient")
    public List<Patient> getSameNamePatient(@RequestParam("name") String name){

        List<Patient> list = new ArrayList<>();

        for (Patient p : patients){
            if(name.equals(p.name)){
                list.add(new Patient(p.name, p.age, p.id));
            }
        }

        return list;
    }

    // sort by age / id / name
    @GetMapping("/sortBy")
    public List<Patient> sortBy(@RequestParam("input") String input){

        if(input.equals("id")){
            patients.sort( (Patient p1, Patient p2) -> Integer.compare(p1.id, p2.id));
        }
        else if(input.equals("age")){
            patients.sort( (Patient p1, Patient p2) -> Integer.compare(p1.age, p2.age));
        }
        else{
            patients.sort( (Patient p1, Patient p2) -> p1.getName().compareTo(p2.getName()));
        }


        return patients;

    }







}

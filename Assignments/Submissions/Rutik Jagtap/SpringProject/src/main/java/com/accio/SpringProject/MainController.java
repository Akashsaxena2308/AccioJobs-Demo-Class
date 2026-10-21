package com.accio.SpringProject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/common")
public class MainController {
    private final List<Patient> patients = new ArrayList<>();
    long id;


    public MainController(){
        patients.add(new Patient("Rutik", 25, 1));
        patients.add(new Patient("Pratuk", 28, 2));
        id =2;
    }
    @GetMapping("/Patient")
    public List<Patient> getPatients(){
        return patients;
    }

    @PostMapping("/addPatient")
    public Patient addPatient(@RequestBody PatientInput patientInput){
        id++;
        Patient patient = new Patient(patientInput.name, patientInput.age, id);
        patients.add(patient);
        return patient;
    }

    @PutMapping("/updatePatient/{id}")
    public List<Patient> updatePatient(@PathVariable long id, @RequestBody PatientInput input){
        for (Patient patient : patients) {
            if (patient.id == id) {
                patient.name = input.name;
                patient.age = input.age;
                return Collections.singletonList(patient);
            }
        }
        return Collections.emptyList();
    }
    @DeleteMapping("/deletePatient/{id}")
    public ResponseEntity<Object> deletePatient(@PathVariable long id){
        //for (Patient P : patients) {
            //if (P.getId() == id) {
                //patients.remove(P);
            //}
        //}
        int flag = 0;
        for (Patient patient : patients) {
            if (patient.id == id) {
                patients.remove(patient);
                flag = 1;
            }
        }
        if (flag == 0){
            return  ResponseEntity.status(404).body("Patient not found!");
        }
        return ResponseEntity.ok(patients);
    }
    @GetMapping("/Search")
    public List<Patient> searchPatient(@RequestParam String name){
        List<Patient> finalpatients = new ArrayList<>();
        for(Patient patient : patients){
            if(patient.name.equals(name)){
                finalpatients.add(patient);
            }
        }
        return finalpatients;
    }
    @GetMapping("/sort")
    public List<Patient> sort(@RequestParam(defaultValue = "name") String by){
        List<Patient> finalpatients = new ArrayList<>();
        for(Patient patient : patients){
            finalpatients.add(patient);
        }
        switch (by.toLowerCase()) {
            case "id":
                finalpatients.sort((p1, p2) -> Long.compare(p1.id, p2.id));
                break;
            case "age":
                finalpatients.sort((p1, p2) -> Integer.compare(p1.age, p2.age));
                break;
            case "name":
            default:
                finalpatients.sort((p1, p2) -> p1.name.compareTo(p2.name));
                break;
        }
        return finalpatients;
    }



}

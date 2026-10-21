package com.acciojob.springProject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/commonPath")
public class MainController {

    private final  List<PatientInfo> patients = new ArrayList<PatientInfo>();
    long id;
    public MainController(){
        patients.add(new PatientInfo(1, "abc", 78));
        patients.add(new PatientInfo(2, "def", 56 ));
        id = 2;
    }
    @GetMapping("/PatientInfo")
    public List<PatientInfo> getPatients(){
        return patients;
    }

    @PostMapping("addPatient")
    public List<PatientInfo> addPatient(@RequestBody PatientInput patientInput){
         patients.add(new PatientInfo(id+1, patientInput.name, patientInput.age));
         id++;
         return patients;
    }

    @PutMapping("/updatePatient/{id}")
    public List<PatientInfo> updatePatient(@PathVariable long id, @RequestBody PatientInput input){
        PatientInfo patient = patients.get((int)id-1);
        patient.setName(input.getName());
        return patients;
    }

    @DeleteMapping("/deletePatients/{id}")
    public ResponseEntity<Object> deletePatient(@PathVariable long id){
//        patients.remove(id-1);
        int flag = 0;
        for(PatientInfo p:patients){
            if(p.getId()==id){
                patients.remove(p);
                flag = 1;
            }
        }
        if(flag == 0){
            return ResponseEntity.status(404).body("Patient not found!");
        }
        return ResponseEntity.ok(patients);
    }

    @GetMapping("/searchPatientByName")
    public List<PatientInfo> searchPatientsByName(@RequestParam() String name){
        List<PatientInfo> searchedPatient=new ArrayList<>();
        for(PatientInfo p:patients){
            if(p.getName().equals(name)){
                searchedPatient.add(p);
            }
        }
        return searchedPatient;
    }

    @GetMapping("/browse")
    public List<PatientInfo> getSortedBy(@RequestParam() String param){
        List<PatientInfo> sortPatient=new ArrayList<>();
        if(param.equals("id")){
            patients.sort(
                (p1, p2) ->
                    Integer.compare((int)p1.getId(), (int)p2.getId())

            );
        }else if(param.equals("name")){
            patients.sort(
                    (p1, p2) ->
                            p1.getName().compareTo(p2.getName())

            );
        }else{
            patients.sort(
                    (p1, p2) ->
                            Integer.compare((int)p1.getAge(), (int)p2.getAge())

            );
        }
        return sortPatient;
    }


}

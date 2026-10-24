package com.accio.springProject.Hospital.Controller;

import com.accio.springProject.Hospital.Entity.Patient;
import com.accio.springProject.Hospital.Model.PatientInput;
import com.accio.springProject.Hospital.Service.HospitalPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

//    @Autowired
    private final HospitalPatientService service;

    public HospitalController(HospitalPatientService service){
        this.service = service;
    }

//    @Autowired
//    public void setService(HospitalPatientService service) {
//        this.service = service;
//    }

    @GetMapping("/search")
    public List<Patient> searchByName(@RequestParam() String name){
        return service.searchByName(name);
    }

    @GetMapping("/patients")
    public List<Patient> getPatients(){
        return service.getPatients();
    }


    @PostMapping("/addPatient")
    public List<Patient> addPatient(@RequestBody PatientInput patientInput){
       return service.addPatient(patientInput);
    }

    @PutMapping("/updatePatient/{id}")
    public List<Patient> updatePatient(@PathVariable long id, @RequestBody PatientInput input){
        return service.updatePatient(id, input);
    }

    @DeleteMapping("/deletePatients/{id}")
    public ResponseEntity<Object> deletePatient(@PathVariable long id){
        if(!service.deletePatient(id)){
            return ResponseEntity.status(404).body("Patient not found!");
        }

        return ResponseEntity.ok(service.deletePatient(id));
    }

    @GetMapping("/browse")
    public List<Patient> getSortedBy(@RequestParam String param){
        return service.getSortedBy(param);
    }

}

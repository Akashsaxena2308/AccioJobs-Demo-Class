package Hospital.Controller;

import Hospital.Entity.Patient;
import Hospital.Model.PatientInput;
import Hospital.Service.HospitalService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
    private final HospitalService service;
    public HospitalController(HospitalService service){
        this.service=service;
    }
    @GetMapping("/search")
    public List<Patient> searchByName(@RequestParam() String name){
        return service.searchByName(name);
    }

    @GetMapping("/patients")
    public List<Patient> getPatients(){
        return service.getPatients();
    }

    @PostMapping("/addpatients")
    public List<Patient> addPatient(@Valid @RequestBody PatientInput patientInput){
        return service.addPatient(patientInput);
    }

    @PutMapping("/updatePatient/{id}")
    public List<Patient> updatePatient(@PathVariable long id,@Valid @RequestBody PatientInput patientInput){
        return service.updatePatient(id,patientInput);
    }

    @DeleteMapping("/deletePatient/{id}")
    public ResponseEntity<Object> deletePatient(@PathVariable long id){
        boolean deleted= service.deletePatient(id);
        if(!deleted){
            return ResponseEntity.status(404).body("Patient Not Found");
        }
        return ResponseEntity.ok(service.getPatients());
    }

    @GetMapping("/browse")
    public List<Patient> getSortedBy(@RequestParam String param){
        return service.getSortedBy(param);
    }
}

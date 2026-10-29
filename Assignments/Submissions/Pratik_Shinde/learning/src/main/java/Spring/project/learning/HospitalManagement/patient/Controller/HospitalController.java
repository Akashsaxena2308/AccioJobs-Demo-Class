package Spring.project.learning.HospitalManagement.patient.Controller;

import Spring.project.learning.HospitalManagement.patient.Entity.Patient;
import Spring.project.learning.HospitalManagement.patient.Model.PatientInput;
import Spring.project.learning.HospitalManagement.patient.Service.HospitalPatientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
    private final HospitalPatientService service;

    public HospitalController(HospitalPatientService service){
        this.service = service;
    }

    @GetMapping("/search")
    public List<Patient> searchByName(@RequestParam() String name){
        return service.searchByName(name);
    }

    @GetMapping("/patients")
    public List<Patient> getPatients(){
        return service.getPatients();
    }


    @PostMapping("/addPatient")
    public List<Patient> addPatient(@Valid @RequestBody PatientInput patientInput){
        return service.addPatient(patientInput);
    }

    @PutMapping("/updatePatient/{id}")
    public List<Patient> updatePatient(@PathVariable long id,@Valid @RequestBody PatientInput input){
        return service.updatePatient(id, input);
    }

    @DeleteMapping("/deletePatients/{id}")
    public ResponseEntity<Object> deletePatient(@PathVariable long id){
        boolean deleted = service.deletePatient(id);
        if(!deleted){
            return ResponseEntity.status(404).body("Patient not found!");
        }
        return ResponseEntity.ok(service.getPatients());
    }

    @GetMapping("/browse")
    public List<Patient> getSortedBy(@RequestParam String param){
        return service.getSortedBy(param);
    }

}
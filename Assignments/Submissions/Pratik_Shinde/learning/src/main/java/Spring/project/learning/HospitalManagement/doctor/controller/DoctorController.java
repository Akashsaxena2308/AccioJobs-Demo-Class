package Spring.project.learning.HospitalManagement.doctor.controller;

import Spring.project.learning.HospitalManagement.doctor.Entity.Doctor;
import Spring.project.learning.HospitalManagement.doctor.Model.DoctorInput;
import Spring.project.learning.HospitalManagement.doctor.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class DoctorController {
    private final DoctorService service;

    public DoctorController(DoctorService service){
        this.service = service;
    }

    @PostMapping("/add_doctor")
    public void add(@RequestParam DoctorInput input){
        service.addDoctor(input);
    }

    @GetMapping("/doctor")
    public List<Doctor> getAllDoctor(){
        return service.getAllDoctor();
    }

    @PutMapping("/{doctor_id}/patient/{patient_id}")
    public DoctorInput assignedPatient(@PathVariable Long doctor_id, @PathVariable Long patient_id){
        return service.assign(doctor_id, patient_id);
    }
}

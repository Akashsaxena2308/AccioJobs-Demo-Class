package com.accio.springProject.Doctors.Controller;

import com.accio.springProject.Doctors.Service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService service;

    public DoctorController(DoctorService service){ // Constructor injection
        this.service = service;
    }

    @PutMapping("/{doctorId}/patients/{patientId}")
    public ResponseEntity<Object> assign(@PathVariable("doctorId") long doctorId,
                                 @PathVariable("patientId") long patientId){
        try{
            return ResponseEntity.ok(service.assign(doctorId, patientId));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping("/{doctorId}/patients")
    public ResponseEntity<Object> getPatients(@PathVariable("doctorId") long doctorId){
        try{
            return ResponseEntity.ok(service.getPatients(doctorId));
        }
        catch (Exception e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}

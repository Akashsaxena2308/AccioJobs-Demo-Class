package com.acciojob.springProject.Doctors.Controller;

import com.acciojob.springProject.Doctors.Model.Doctor;
import com.acciojob.springProject.Doctors.Model.DoctorWorkload;
import com.acciojob.springProject.Doctors.Model.RebalanceResult;
import com.acciojob.springProject.Doctors.Service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;
@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService service;
    public DoctorController(DoctorService service){
        this.service = service;
    }

    @PutMapping("/{doctorId}/patients/{patientId}")
    public ResponseEntity<Object> assign(@PathVariable("doctorId") long doctorId,
                                         @PathVariable("patientId") long patientId){

        try{
            return ResponseEntity.ok(service.assign(doctorId, patientId));
        }catch(Exception e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping("/{doctorId}/patients")
    public ResponseEntity<Object> getPatients(@PathVariable("doctorId") long doctorId){
        try{
            return ResponseEntity.ok(service.getPatients(doctorId));
        }catch(Exception e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping("/workload")
    public ResponseEntity<List<DoctorWorkload>> getWorkload(){
        return ResponseEntity.ok(service.getWorkload());
    }

    @PostMapping("/rebalance")
    public ResponseEntity<RebalanceResult> rebalance(){
        return ResponseEntity.ok(service.rebalance());
    }
}



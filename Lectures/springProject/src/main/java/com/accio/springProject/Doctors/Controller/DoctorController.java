package com.accio.springProject.Doctors.Controller;

import com.accio.springProject.Doctors.Service.DoctorService;
import com.accio.springProject.Doctors.Model.ApiError;
import com.accio.springProject.Doctors.Model.DoctorWorkload;
import com.accio.springProject.Doctors.Model.RebalanceResult;
import com.accio.springProject.Doctors.Exception.DoctorNotFoundException;
import com.accio.springProject.Doctors.Exception.PatientNotFoundException;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    private final DoctorService service;

    public DoctorController(DoctorService service) {
        this.service = service;
    }

    @PutMapping("/{doctorId}/patients/{patientId}")
    public ResponseEntity<Object> assign(@PathVariable("doctorId") long doctorId,
                                         @PathVariable("patientId") long patientId) {
        try {
            return ResponseEntity.ok(service.assign(doctorId, patientId));
        } catch (DoctorNotFoundException | PatientNotFoundException ex) {
            return ResponseEntity.status(404).body(new ApiError(ex.getMessage()));
        }
    }

    @GetMapping("/{doctorId}/patients")
    public ResponseEntity<Object> getPatients(@PathVariable("doctorId") long doctorId) {
        try {
            return ResponseEntity.ok(service.getPatients(doctorId));
        } catch (DoctorNotFoundException ex) {
            return ResponseEntity.status(404).body(new ApiError(ex.getMessage()));
        }
    }

    @GetMapping("/workload")
    public ResponseEntity<List<DoctorWorkload>> getWorkload() {
        return ResponseEntity.ok(service.getWorkload());
    }

    @PostMapping("/rebalance")
    public ResponseEntity<RebalanceResult> rebalance() {

        return ResponseEntity.ok(service.rebalance());
    }
}

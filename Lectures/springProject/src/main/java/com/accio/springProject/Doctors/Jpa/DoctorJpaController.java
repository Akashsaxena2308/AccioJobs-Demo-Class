package com.accio.springProject.Doctors.Jpa;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/jpa/doctors")
public class DoctorJpaController {

    private final DoctorJpaService service;

    public DoctorJpaController(DoctorJpaService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public Optional<DoctorJpaEntity> getDoctorById(@PathVariable("id") Long id){
        return service.getDoctorById(id);
    }
}

package com.accio.springProject.Doctors.Jpa;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorJpaService {

    private final DoctorJpaRepository repository;

    public DoctorJpaService(DoctorJpaRepository repository){

        this.repository = repository;
    }

    public Optional<DoctorJpaEntity> getDoctorById(long id){

        return repository.findById(id);
    }

    public List<DoctorJpaEntity> getDoctorByName(String name){
        return repository.findByName(name);
    }
}

package com.accio.springProject.DiInjection;

import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private final PatientRepository repository;

    public PatientService(PatientRepository repository){
        this.repository = repository;
    }

    public String getPatientName(long id){
        return repository.findNameById(id);
    }
}

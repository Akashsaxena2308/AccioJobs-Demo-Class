package com.accio.springProject.DependencyInjection;

public class PatientService {

    private final PatientRepository repository;

    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    public String getPatientName(long id) {
        return repository.findNameById(id);
    }

}

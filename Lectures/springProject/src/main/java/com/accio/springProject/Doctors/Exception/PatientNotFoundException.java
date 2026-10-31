package com.accio.springProject.Doctors.Exception;

public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(long id) {
        super("Patient " + id + " not found");
    }
}

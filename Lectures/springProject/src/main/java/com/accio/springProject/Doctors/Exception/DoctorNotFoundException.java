package com.accio.springProject.Doctors.Exception;

public class DoctorNotFoundException extends RuntimeException {
    public DoctorNotFoundException(long id) {
        super("Doctor " + id + " not found");
    }
}

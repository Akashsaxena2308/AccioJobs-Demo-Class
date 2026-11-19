package com.acciojob.springProject.Doctors.Model;

import com.acciojob.springProject.HospitalManagement.Entity.Patient;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private final long id;
    private final String name;
    private List<Patient> patientList = new ArrayList<>();

    public Doctor(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
            return id;
    }
    
    public String getName() {
        return name;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }
}

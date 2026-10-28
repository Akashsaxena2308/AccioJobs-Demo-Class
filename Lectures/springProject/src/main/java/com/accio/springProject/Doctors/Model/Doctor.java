package com.accio.springProject.Doctors.Model;

import com.accio.springProject.Hospital.Entity.Patient;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private final long id;
    private final String name;
    private List<Patient> patientList = new ArrayList<>();

    public Doctor(long id, String name){
        this.id = id;
        this.name = name;
    }

    public long getId(){
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

//User input --> Controller --> Object

//User input --> Doctor --> Id , Name [SQL insert --> seeding]
//final
//User --> name --> Doctor d1.name = "doctor1";
//service --> create doctor --> Repository --> Create new row for Doctor d1 in doctors table

//Controller --> new api call --> Doctor d1

//Entity -->
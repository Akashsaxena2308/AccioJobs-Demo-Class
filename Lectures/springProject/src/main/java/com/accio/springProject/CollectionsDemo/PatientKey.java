package com.accio.springProject.CollectionsDemo;

import com.accio.springProject.Hospital.Entity.Patient;

public class PatientKey {

    private final long id;

    public PatientKey(long id){
        this.id = id;
    }

    @Override
    public boolean equals(Object other){
        if(this == other){
            return true;
        }

        if(!(other instanceof PatientKey)){
            return false;
        }

        PatientKey that = (PatientKey) other;
        return id == that.id;
    }


}

// PatientKey  ---> { id : 5} --> other
// other instanceOf PatientKey --> true

// String --> "Name"  --> other

// other instanceOf PatientKey --> False

//Patient patient = new Patient ("Name", 5, 55);


// PatienKey p = new PatientKey(5);
// p.equals("Test string");

// "5"



// equal --> Method --> Compares 2 patient objects

// equals(PK1, PK2){
//
//PK1.id == PK2.id
//}

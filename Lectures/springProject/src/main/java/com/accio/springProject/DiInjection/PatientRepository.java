package com.accio.springProject.DiInjection;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PatientRepository {

    private final Map<Long, String> names = new HashMap<>();

    public PatientRepository(){
        names.put(1L, "John");
    }

    public String findNameById(long id){
        return names.get(id);
    }

    public void rename(long id, String name){
        names.put(id, name);
    }
}


//Frontend  --> API --> Backend --> Controller --> Service --> Repository
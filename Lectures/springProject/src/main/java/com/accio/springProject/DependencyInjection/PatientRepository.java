package com.accio.springProject.DependencyInjection;

import java.util.HashMap;
import java.util.Map;

public class PatientRepository {

    private final Map<Long, String> names = new HashMap<>();

    public PatientRepository() {
        names.put(1L, "Asha");
    }

    public String findNameById(long id) {
        return names.get(id);
    }

    public void rename(long id, String name) {
        names.put(id, name);
    }
}

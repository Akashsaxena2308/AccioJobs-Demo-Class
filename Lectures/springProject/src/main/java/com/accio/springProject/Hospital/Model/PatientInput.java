package com.accio.springProject.Hospital.Model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class PatientInput {

    @NotNull
    String name;

    @NotNull
    @Min(value = 0, message = "Age should be atleast 0")
    @Max(value = 120, message = "Age cannot be more than 120")
    int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

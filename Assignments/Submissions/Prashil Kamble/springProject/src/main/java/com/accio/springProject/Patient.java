package com.accio.springProject;

public class Patient {

    String name;
    int age;
    int id;

    Patient(String name, int age, int id){
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public int getId(){
        return id;
    }

}

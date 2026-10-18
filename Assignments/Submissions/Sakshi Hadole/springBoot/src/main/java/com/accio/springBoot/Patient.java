package com.accio.springBoot;

public class Patient {
   private String name;
   private int age;
   private long id;

    Patient(long id,String name,int age){
        this.name=name;
        this.age=age;
        this.id=id;
    }

    public String getName() {
        return name;
    }
    public int getAge(){
        return age;
    }
    public long getId(){
        return id;
    }
    public void setName(String name){
        this.name=name;
    }
}

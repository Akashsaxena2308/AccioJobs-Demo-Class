package com.accio.springProject;

import javax.swing.*;
import java.util.List;

public class Patients {
    private int id;
    private String name;

    Patients(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

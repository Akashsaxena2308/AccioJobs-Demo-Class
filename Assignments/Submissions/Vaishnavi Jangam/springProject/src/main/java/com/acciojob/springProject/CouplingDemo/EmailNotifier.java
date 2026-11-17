package com.acciojob.springProject.CouplingDemo;

import org.springframework.stereotype.Component;

@Component
public class EmailNotifier implements Notifier{

    public String send(String message){
        return "Email "+ message;
    }
}

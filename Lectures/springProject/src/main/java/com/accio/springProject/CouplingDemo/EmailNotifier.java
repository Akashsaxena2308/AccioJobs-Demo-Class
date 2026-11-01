package com.accio.springProject.CouplingDemo;

import org.springframework.stereotype.Component;

@Component("email")
public class EmailNotifier implements Notifier{

    public EmailNotifier(){

    }

    @Override
    public String send(String message){
        return "EMAIL : " +  message;
    }
}

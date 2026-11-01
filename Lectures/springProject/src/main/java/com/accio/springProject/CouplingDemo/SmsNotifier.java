package com.accio.springProject.CouplingDemo;

import org.springframework.stereotype.Component;

@Component("sms")
public class SmsNotifier implements Notifier{

    public String send(String message){
        return "SMS : "+message;
    }
}

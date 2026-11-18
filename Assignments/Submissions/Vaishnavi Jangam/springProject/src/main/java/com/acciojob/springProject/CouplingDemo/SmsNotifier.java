package com.acciojob.springProject.CouplingDemo;

import org.springframework.stereotype.Component;

@Component("sms")
public class SmsNotifier implements Notifier {
    @Override
    public String send(String message){
        return "SMS" + message;
    }
}


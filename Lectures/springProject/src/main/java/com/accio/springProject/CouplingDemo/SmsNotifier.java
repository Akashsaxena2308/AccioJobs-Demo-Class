package com.accio.springProject.CouplingDemo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("sms")
public class SmsNotifier implements Notifier{

    @Override
    public String send(String message){
        return "SMS : " + message;
    }
}

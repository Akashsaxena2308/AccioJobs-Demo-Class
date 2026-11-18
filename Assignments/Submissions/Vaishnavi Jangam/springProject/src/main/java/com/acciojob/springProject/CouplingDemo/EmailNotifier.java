package com.acciojob.springProject.CouplingDemo;

import org.springframework.stereotype.Component;

@Component("email")
public class EmailNotifier implements Notifier {

    public EmailNotifier() {

    }
    @Override
    public String send(String message) {
        return "Email: " + message;
    }

}

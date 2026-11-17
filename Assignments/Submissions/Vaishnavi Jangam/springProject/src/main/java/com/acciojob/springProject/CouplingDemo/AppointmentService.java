package com.acciojob.springProject.CouplingDemo;

import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    private final EmailNotifier notifier;

    public AppointmentService(EmailNotifier notifier) {
        this.notifier = notifier;
    }

    public String ConfirmAppointment(){
        return notifier.send("Your appointment has been confirmed.");
    }

}

package com.accio.springProject.CouplingDemo;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AppointmentService {

//    private final Notifier notifier;
    private final Map<String, Notifier> notifierImpl;
    public AppointmentService(Map<String, Notifier> notifiers){ //Constructor injection
        this.notifierImpl = notifiers;
    }

    public String confirmAppointment(boolean urgent){
        String channel = urgent ? "sms" : "email";

        return notifierImpl.get(channel).send("Appointment is confirmed!");
//        return notifier.send("Appointment is confirmed!");
    }
}

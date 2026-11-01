package com.accio.springProject.CouplingDemo;

import jakarta.validation.constraints.Max;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AppointmentService {

    private final Map<String, Notifier> notifierImpl;
    public AppointmentService(Map<String, Notifier> notifierImpl){
        this.notifierImpl = notifierImpl;
    }

    public String confirmAppointment(boolean urgent){
        String channel = urgent ? "sms" : "email";
        return notifierImpl.get(channel).send("Appointment is confirmed!");
    }
}

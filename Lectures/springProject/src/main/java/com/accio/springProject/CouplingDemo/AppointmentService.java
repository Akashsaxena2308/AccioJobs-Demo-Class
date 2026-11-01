package com.accio.springProject.CouplingDemo;

import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    private final Notifier notifier;

    public AppointmentService(Notifier notifier){
        this.notifier = notifier;
    }

//    public String confirmAppointment(AppointmentService service){
//        return;
//    }
}

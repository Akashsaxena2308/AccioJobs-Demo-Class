package com.accio.springProject.CouplingDemo;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {
    private final AppointmentService service;

    public AppointmentController(AppointmentService service){
        this.service = service;
    }

    public String confirmAppointment(@RequestParam(name = "urgent") boolean urgent){
        return service.confirmAppointment(urgent);
    }
}

package com.accio.springProject.CouplingDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {
    private final AppointmentService service;

    public AppointmentController(AppointmentService service){ //Constructor injection
        this.service = service;
    }

    @PostMapping("/demo/appointment/confirmation")
    public String confirmAppointment(@RequestParam(name = "urgent") boolean urgent){
        return service.confirmAppointment(urgent);
    }
}

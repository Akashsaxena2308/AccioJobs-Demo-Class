package com.accio.springProject.Deployment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
    @GetMapping("/demo/status")
    public String status() {
        return "Hospital service is running - v1";
    }
}
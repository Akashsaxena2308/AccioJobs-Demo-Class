package com.acciojob.springProject.RuntimeDemo;

import org.springframework.web.bind.annotation.GetMapping;

public class StatusController {
    @GetMapping("/demo/status")
    public String deployStatus(){
        return "Service is deployed at v1";
    }
}

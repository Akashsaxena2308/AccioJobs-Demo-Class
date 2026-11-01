package com.accio.springProject.RuntimeDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping("/demo/status")
    public String deployStatus(){
        return "Service deployed";
    }
}

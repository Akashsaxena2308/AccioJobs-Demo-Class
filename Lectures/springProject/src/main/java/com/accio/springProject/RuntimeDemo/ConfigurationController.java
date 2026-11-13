package com.accio.springProject.RuntimeDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigurationController {
    private final String banner;

    public ConfigurationController(
            @Value("${demo.banner:Hospital Default}") String banner
    ){
        this.banner = banner;
    }

    @GetMapping("/demo/config")
    public String configType(){
        return banner;
    }
}
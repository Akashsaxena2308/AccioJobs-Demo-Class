package com.acciojob.springProject.RuntimeDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigurationController {
    private final String Banner;
    public ConfigurationController(@Value("${demo.Banner: Hospital Default}")String Banner)  {
        this.Banner=Banner;
    }

    @GetMapping("demo/config")
    public String configType() {
        return Banner;
    }
}

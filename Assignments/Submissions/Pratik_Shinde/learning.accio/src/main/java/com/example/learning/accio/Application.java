package com.example.learning.accio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	@GetMapping("/api")
	public String print(@RequestParam String name){
		return "Hello from "+name +". Learning springboot.";
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

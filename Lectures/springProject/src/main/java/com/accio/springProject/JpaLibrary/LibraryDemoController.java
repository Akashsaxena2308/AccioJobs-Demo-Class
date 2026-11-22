package com.accio.springProject.JpaLibrary;

import org.apache.tomcat.jni.Library;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jpa/library")
public class LibraryDemoController {

    private final LibraryDemoService demoService;

    public LibraryDemoController(LibraryDemoService service){
        this.demoService = service;
    }

    @GetMapping("/student/{id}")
    public LibraryViews.StudentView studentDetails(@PathVariable("id") Long id){
        return this.demoService.student(id);
    }
}

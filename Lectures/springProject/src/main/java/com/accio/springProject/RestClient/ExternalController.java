package com.accio.springProject.RestClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExternalController {

    private static final Logger log = LoggerFactory.getLogger(ExternalController.class);
    private final ExternalService service;

    public ExternalController(ExternalService service){
        this.service = service;
    }

    @GetMapping("/tasks/{id}")
    public TaskSummary findTask(@PathVariable("id") long id){
        log.info("User requested for task with id : " + id);
        TaskSummary summary = service.findTask(id);
        log.info(summary.getId() + " " + summary.getTitle());
        return summary;
    }
}

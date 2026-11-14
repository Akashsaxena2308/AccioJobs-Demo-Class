package com.accio.springProject.RestClient;

import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import java.util.Map;

@RestController
public class ExternalController {

    private static final Logger log = LoggerFactory.getLogger(ExternalController.class);
    private final ExternalService service;

    public ExternalController(ExternalService service){
        this.service = service;
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<?> findTask(@PathVariable("id") long id){
//        log.info("User requested for task with id : " + id);
//        TaskSummary summary = service.findTask(id);
//        log.info(summary.getId() + " " + summary.getTitle());
//        return summary;

        if(id<=0){
            return ResponseEntity.badRequest().body(Map.of("message", "Task ID must be positive!"));
        }

        try{
            return ResponseEntity.ok(service.findTask(id));
        }
        catch (RestClientException ex){
            log.warn("Restclient exception!" + ex.getMessage());

            return ResponseEntity.status(502).body(Map.of("message", "Service provider not available"));
        }
    }


    @GetMapping("/demo/users/{userId}/task-summary")
    public ResponseEntity<?> summarizeUserTasks(@PathVariable("userId") long userId) {
        if (userId <= 0) {
            return ResponseEntity.badRequest().body(Map.of("message", "User ID must be positive"));
        }

        try {
            return ResponseEntity.ok(service.summarizeUserTasks(userId));
        } catch (ExternalService.UserNotFoundException ex) {
            return ResponseEntity.status(404).body(Map.of("message", "User not found"));
        } catch (RestClientException ex) {
            log.warn("Task summary provider failure for user {}: {}", userId,
                    ex.getClass().getSimpleName());
            return ResponseEntity.status(502).body(Map.of("message", "Service provider not available"));
        }
    }

    //userID --> Tasks
    // Userid, name, total task, completed, pending


    //External Controller --> ExternalService

    // ExternalService --> RestClient --> get call

    // 1st get --> todos -- list of tasks
    // 2nd get --> user detail --> user name

    //list of tasks -- filter out -->filtered list user id  --> count completed -->
}

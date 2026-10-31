package com.accio.springProject.ExternalApi;

import java.net.SocketTimeoutException;
import java.net.http.HttpTimeoutException;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;

@RestController
@RequestMapping("/demo/tasks")
public class TaskController {
    private static final Logger log =
            LoggerFactory.getLogger(TaskController.class);
    private final ExternalTaskService service;

    public TaskController(ExternalTaskService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findTask(@PathVariable("id") long id) {
        if (id <= 0) {
            return ResponseEntity.badRequest()
                    .body(Map.of("message", "Task ID must be positive"));
        }

        try {
            return ResponseEntity.ok(service.findTask(id));
        } catch (RestClientResponseException ex) {
            if (ex.getStatusCode().value() == 404) {
                return ResponseEntity.status(404)
                        .body(Map.of("message", "Task not found"));
            }
            log.warn("Task provider returned HTTP {} for task {}",
                    ex.getStatusCode().value(), id);
            return ResponseEntity.status(502)
                    .body(Map.of("message", "Task provider request failed"));
        } catch (ResourceAccessException ex) {
            boolean timedOut = isTimeout(ex);
            log.warn("Task provider transport failure for task {}; timeout={}",
                    id, timedOut);
            return ResponseEntity.status(timedOut ? 504 : 502)
                    .body(Map.of("message", timedOut
                            ? "Task provider timed out"
                            : "Task provider unavailable"));
        } catch (RestClientException ex) {
            log.warn("Task provider response could not be read for task {}", id);
            return ResponseEntity.status(502)
                    .body(Map.of("message", "Invalid task provider response"));
        }
    }

    private boolean isTimeout(Throwable error) {
        for (Throwable cause = error; cause != null; cause = cause.getCause()) {
            if (cause instanceof HttpTimeoutException
                    || cause instanceof SocketTimeoutException) {
                return true;
            }
        }
        return false;
    }
}
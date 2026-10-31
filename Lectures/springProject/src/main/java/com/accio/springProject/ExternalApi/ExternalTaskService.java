package com.accio.springProject.ExternalApi;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

@Service
public class ExternalTaskService {
    private final RestClient taskRestClient;

    public ExternalTaskService(RestClient taskRestClient) {
        this.taskRestClient = taskRestClient;
    }

    public TaskSummary findTask(long id) {
        ExternalTodo todo = taskRestClient.get()
                .uri("/todos/{id}", id)
                .retrieve()
                .body(ExternalTodo.class);

        if (todo == null) {
            throw new RestClientException("Task provider returned no body");
        }

        String status = todo.isCompleted() ? "DONE" : "PENDING";
        return new TaskSummary(todo.getId(), todo.getTitle(), status);
    }
}

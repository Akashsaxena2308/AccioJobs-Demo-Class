package com.accio.springProject.RestClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class ExternalService {
    private final RestClient taskRestClient;
    private static final Logger log = LoggerFactory.getLogger(ExternalService.class);

    public ExternalService(RestClient client){ //Constructor injection
        this.taskRestClient = client;
    }

    //INTERNET
    // protocol : hostname : port : resource
    //https://jsonplaceholder.com/todos/1

    public TaskSummary findTask(long id){

        log.info("Fetching task {} from provider", id);
        ExternalTodo todo = taskRestClient.get()
                .uri("/todos/{id}", id)
                .retrieve()
                .body(ExternalTodo.class);

        if(todo == null){
            throw new RestClientException("Task provider returned no body");
        }

        log.info("Fetched task {} from provider", todo.getId());

        return new TaskSummary(todo.getId(), todo.getTitle(), todo.isCompleted());
    }

    public UserTaskSummary summarizeUserTasks(long userId) {
        ExternalUser user = fetchUser(userId);
        ExternalTodo[] todos = taskRestClient.get()
                .uri("/todos")
                .retrieve()
                .body(ExternalTodo[].class);

        if (todos == null) {
            throw new RestClientException("Task provider returned no task list");
        }

        int total = 0;
        int completed = 0;
        for (ExternalTodo todo : todos) {
            if (todo == null) {
                throw new RestClientException("Task provider returned a null task");
            }
            if (todo.getUserId() != user.id()) {
                continue;
            }
            total++;
            if (todo.isCompleted()) {
                completed++;
            }
        }
        return new UserTaskSummary(user.id(), user.name(), total, completed, total - completed);
    }

    private ExternalUser fetchUser(long userId) {
        try {
            ExternalUser user = taskRestClient.get()
                    .uri("/users/{id}", userId)
                    .retrieve()
                    .body(ExternalUser.class);
            if (user == null || user.id() != userId || user.name() == null) {
                throw new RestClientException("Task provider returned invalid user details");
            }
            return user;
        } catch (HttpClientErrorException.NotFound ex) {
            throw new UserNotFoundException(ex);
        }
    }

    static class UserNotFoundException extends RuntimeException {
        UserNotFoundException(Throwable cause) {
            super(cause);
        }
    }
}

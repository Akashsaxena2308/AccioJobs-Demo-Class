package com.accio.springProject.RestClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

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
}

package com.accio.springProject.RestClient;

public class TaskSummary {
    private final long id;
    private final String title;
    private final boolean status;

    public TaskSummary(long id, String title, boolean status){
        this.id = id;
        this.status = status;
        this.title = title;
    }


    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean getStatus() {
        return status;
    }
}

// 1, TitleTask1, Status

//REST Client ---> API call to another service

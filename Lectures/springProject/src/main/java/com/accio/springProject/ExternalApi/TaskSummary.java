package com.accio.springProject.ExternalApi;

public class TaskSummary {
    private final long id;
    private final String title;
    private final String status;

    public TaskSummary(long id, String title, String status) {
        this.id = id;
        this.title = title;
        this.status = status;
    }

    public long getId() { return id; }
    public String getTitle() { return title; }
    public String getStatus() { return status; }
}
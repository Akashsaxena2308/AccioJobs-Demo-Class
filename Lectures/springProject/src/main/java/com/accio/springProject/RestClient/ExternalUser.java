package com.accio.springProject.RestClient;

//Validate userId before making an external call. Fetch GET /users/{userId}
// from the provider to confirm the user exists and get their name.
// Then fetch GET /users/{userId}/todos to get that user's task list.
// Count completed and pending tasks using the completed field, and
// return one response with userId, name, totalTasks, completedTasks and pendingTasks.
// Reuse the configured RestClient and its timeout settings.
//
//Example response for a fictional user with three tasks, two completed and one pending.

//        {"userId":1,"name":"Example User","totalTasks":3,"completedTasks":2,"pendingTasks":1}
public class ExternalUser {
    private long userId;
    private String name;
    private int totalTasks;
    private int completedTasks;
    private int pendingTasks;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTotalTasks(int totalTasks) {
        this.totalTasks = totalTasks;
    }

    public void setCompletedTasks(int completedTasks) {
        this.completedTasks = completedTasks;
    }

    public void setPendingTasks(int pendingTasks) {
        this.pendingTasks = pendingTasks;
    }

    public long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public int getTotalTasks() {
        return totalTasks;
    }

    public int getCompletedTasks() {
        return completedTasks;
    }

    public int getPendingTasks() {
        return pendingTasks;
    }
}

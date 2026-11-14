package com.accio.springProject.RestClient;

public record UserTaskSummary(long userId, String name, int totalTasks,
                              int completedTasks, int pendingTasks) {
}

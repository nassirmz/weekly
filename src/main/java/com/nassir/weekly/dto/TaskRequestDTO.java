package com.nassir.weekly.dto;

public class TaskRequestDTO {
    private boolean weeklyTask;
    private TaskDTO task;

    public TaskRequestDTO() {
    }

    public TaskRequestDTO(boolean weeklyTask, TaskDTO task) {
        this.weeklyTask = weeklyTask;
        this.task = task;
    }

    public boolean isWeeklyTask() {
        return weeklyTask;
    }

    public void setWeeklyTask(boolean weeklyTask) {
        this.weeklyTask = weeklyTask;
    }

    public TaskDTO getTask() {
        return task;
    }

    public void setTask(TaskDTO task) {
        this.task = task;
    }
}

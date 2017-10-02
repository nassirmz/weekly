package com.nassir.weekly.dto;

import java.util.List;

public class TasksDTO {
    private List<TaskDTO> tasks;

    public TasksDTO(List<TaskDTO> tasks) {
        this.tasks = tasks;
    }

    public List<TaskDTO> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDTO> tasks) {
        this.tasks = tasks;
    }
}

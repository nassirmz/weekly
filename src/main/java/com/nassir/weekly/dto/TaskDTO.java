package com.nassir.weekly.dto;

import java.time.DayOfWeek;

public class TaskDTO {
    private int taskId;
    private String taskName;
    private short points;
    private short finishedPoints = 0;
    private DayOfWeek day;

    public TaskDTO() {
    }

    public TaskDTO(int taskId, String taskName, short points, short finishedPoints, DayOfWeek day) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.points = points;
        this.finishedPoints = finishedPoints;
        this.day = day;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public short getPoints() {
        return points;
    }

    public void setPoints(short points) {
        this.points = points;
    }

    public short getFinishedPoints() {
        return finishedPoints;
    }

    public void setFinishedPoints(short finishedPoints) {
        this.finishedPoints = finishedPoints;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }
}

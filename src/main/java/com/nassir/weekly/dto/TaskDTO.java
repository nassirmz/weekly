package com.nassir.weekly.dto;

import java.util.HashSet;
import java.util.Set;

public class TaskDTO {
    private String taskName;
    private short points;

    public Set<DayDTO> getDays() {
        return days;
    }

    public void setDays(Set<DayDTO> days) {
        this.days = days;
    }

    private Set<DayDTO> days = new HashSet<DayDTO>();

    public TaskDTO() {
    }

    public TaskDTO(String taskName, short points, Set<DayDTO> days) {
        this.taskName = taskName;
        this.points = points;
        this.days = days;
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


}

package com.nassir.weekly.dto;

import java.util.HashSet;
import java.util.Set;

public class TaskDTO {
    private String taskName;
    private short points;
    private Set<DayDTO> daysDTO = new HashSet<DayDTO>();

    public TaskDTO() {
    }

    public TaskDTO(String taskName, short points, Set<DayDTO> daysDTO) {
        this.taskName = taskName;
        this.points = points;
        this.daysDTO = daysDTO;
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

    public Set<DayDTO> getDaysDTO() {
        return daysDTO;
    }

    public void setDaysDTO(Set<DayDTO> daysDTO) {
        this.daysDTO = daysDTO;
    }
}

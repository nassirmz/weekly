package com.nassir.weekly.domain;

import javax.persistence.*;
import java.time.DayOfWeek;


@Entity
@Table(name = "tasks")
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "points")
    private short points = 1;

    @Column(name = "finished_points")
    private short finishedPoints = 0;

    private DayOfWeek day;

    public TaskModel() {
    }

    public TaskModel(String taskName, short points, short finishedPoints, DayOfWeek day) {
        this.taskName = taskName;
        this.points = points;
        this.finishedPoints = finishedPoints;
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

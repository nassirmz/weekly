package com.nassir.weekly.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by nassir on 9/21/17.
 */
@Entity
@Table(name = "tasks")
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "points")
    private short points;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "task_day",
            joinColumns = @JoinColumn(name="task_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="day_id", referencedColumnName = "id"))
    private Set<DayModel> days = new HashSet<DayModel>();

    public TaskModel() {
    }

    public TaskModel(String taskName, short points, Set<DayModel> days) {
        this.taskName = taskName;
        this.points = points;
        this.days = days;
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

    public Set<DayModel> getDays() {
        return days;
    }

    public void setDays(Set<DayModel> days) {
        this.days = days;
    }
}

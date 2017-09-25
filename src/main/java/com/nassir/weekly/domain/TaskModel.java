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
    @Column(name = "task_id")
    private int id;

    @Column(name = "task_name")
    private String taskName;

    @ManyToMany
    @JoinTable(name = "task_day",
            joinColumns = @JoinColumn(name="task_id", referencedColumnName = "task_id"),
            inverseJoinColumns = @JoinColumn(name="day_id", referencedColumnName = "day_id"))
    private Set<DayModel> days = new HashSet<DayModel>();

    public TaskModel() {
    }

    public TaskModel(String taskName) {
        this.taskName = taskName;
    }

    public int getTask_id() {
        return id;
    }

    public void setTask_id(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Set<DayModel> getDays() {
        return days;
    }

    public void setDays(Set<DayModel> days) {
        this.days = days;
    }
}

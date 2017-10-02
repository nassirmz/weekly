package com.nassir.weekly.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.time.DayOfWeek;

/**
 * Created by nassir on 9/24/17.
 */
@Entity
@Table(name = "days")
public class DayModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int minutes;

    @Enumerated(EnumType.STRING)
    private DayOfWeek day;

    public DayModel() {
    }

    public DayModel(int minutes, DayOfWeek day, Set<TaskModel> tasks) {
        this.minutes = minutes;
        this.day = day;
        this.tasks = tasks;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinTable(name = "task_day",
            joinColumns = @JoinColumn(name="day_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="task_id", referencedColumnName = "id"))
    private Set<TaskModel> tasks = new HashSet<TaskModel>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public void setTasks(Set<TaskModel> tasks) {
        this.tasks = tasks;
    }


    public Set<TaskModel> getTasks() {
        return tasks;
    }

}

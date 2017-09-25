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
    @Column(name = "day_id")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "day")
    private DayOfWeek day;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public Set<TaskModel> getTasks() {
        return tasks;
    }

    public void setTasks(Set<TaskModel> tasks) {
        this.tasks = tasks;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinTable(name = "task_day",
            joinColumns = @JoinColumn(name="day_id", referencedColumnName = "day_id"),
            inverseJoinColumns = @JoinColumn(name="task_id", referencedColumnName = "task_id"))
    private Set<TaskModel> tasks = new HashSet<TaskModel>();
}

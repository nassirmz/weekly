package com.nassir.weekly.dto;

import java.time.DayOfWeek;


public class DayDTO {
    private int minutes;
    private DayOfWeek day;

    public DayDTO() {
    }

    public DayDTO(int minutes, DayOfWeek day) {
        this.minutes = minutes;
        this.day = day;
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
}

package com.nassir.weekly.transformer;

import com.nassir.weekly.domain.DayModel;
import com.nassir.weekly.dto.DayDTO;

import java.time.DayOfWeek;

public class DaysTransfomer {
    private int minutes;
    private DayOfWeek day;

    public static DayDTO tranform(DayModel day) {
        if (day == null) {
            return null;
        } else {
            return new DayDTO(day.getMinutes(), day.getDay());
        }
    }
}

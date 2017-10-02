package com.nassir.weekly.transformer;

import com.nassir.weekly.domain.DayModel;
import com.nassir.weekly.domain.TaskModel;
import com.nassir.weekly.dto.DayDTO;
import com.nassir.weekly.dto.TaskDTO;

import java.util.HashSet;
import java.util.Set;

public class TasksTranformer {

    public static TaskDTO tranform(TaskModel task) {
        if (task == null) {
            return null;
        } else {

            Set<DayDTO> dayDTOS = new HashSet<>();
            for(DayModel day : task.getDays()) {
                dayDTOS.add(DaysTransfomer.tranform(day));
            }
            return new TaskDTO(task.getTaskName(), task.getPoints(), dayDTOS);
        }
    }

}

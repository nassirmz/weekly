package com.nassir.weekly.transformer;

import com.nassir.weekly.domain.DayModel;
import com.nassir.weekly.domain.TaskModel;
import com.nassir.weekly.dto.DayDTO;
import com.nassir.weekly.dto.TaskDTO;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class TasksTranformer {

    public TaskDTO tranform(TaskModel task) {
        if (task == null) {
            return null;
        } else {

            return new TaskDTO(task.getTaskName(), task.getPoints(), populateDays(task.getDays()));
        }
    }

    private Set<DayDTO> populateDays(Set<DayModel> dayModels) {
        Set<DayDTO> days = new HashSet<DayDTO>();
        days.forEach(dayModel -> {
            DayDTO day = new DayDTO();
            day.setDay(dayModel.getDay());
            day.setMinutes(dayModel.getMinutes());
            days.add(day);
        });

        return days;
    }
}

package com.nassir.weekly.transformer;

import com.nassir.weekly.domain.TaskModel;
import com.nassir.weekly.dto.TaskRequestDTO;
import com.nassir.weekly.dto.TaskDTO;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

@Component
public class TaskTransformer {
    public TaskDTO transformTaskResponse(TaskModel taskModel) {
        return new TaskDTO(taskModel.getTaskName(), taskModel.getPoints(), taskModel.getFinishedPoints(), taskModel.getDay());
    }

    public TaskModel transformTaskRequest(TaskDTO task) {
        return new TaskModel(task.getTaskName(), task.getPoints(), task.getFinishedPoints(), task.getDay());
    }

    public List<TaskModel> transformTaskAllWeekRequest(TaskDTO task) {
        List<TaskModel> taskModels = new ArrayList<>();
        String taskName = task.getTaskName();
        short points = task.getPoints();
        short finishedPoints = task.getFinishedPoints();
        for (int i = 1; i <= 7; i++) {
            taskModels.add(new TaskModel(taskName, points, finishedPoints, DayOfWeek.of(i)));
        }

        return taskModels;
    }
}

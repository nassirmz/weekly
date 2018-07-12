package com.nassir.weekly.controller;

import com.nassir.weekly.domain.TaskModel;
import com.nassir.weekly.dto.TaskDTO;
import com.nassir.weekly.dto.TaskRequestDTO;
import com.nassir.weekly.service.TaskService;
import com.nassir.weekly.transformer.TaskTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class TaskController {

    private final Logger LOGGER = LoggerFactory.getLogger(TaskController.class);

    private TaskService taskService;
    private TaskTransformer taskTransformer;

    @Autowired
    public TaskController(TaskService taskService, TaskTransformer taskTransformer) {
        this.taskService = taskService;
        this.taskTransformer = taskTransformer;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/tasks")
    public List<TaskDTO> getTasks() {
        List<TaskDTO> tasks = new ArrayList<>();
        for (TaskModel taskModel : taskService.checkGetTasks()) {
            tasks.add(taskTransformer.transformTaskResponse(taskModel));
        }
        return tasks;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    public ResponseEntity persistTask(@RequestBody TaskRequestDTO taskRequestDTO) {

        TaskDTO taskDTO = taskRequestDTO.getTask();

        List<TaskDTO> taskDTOS = new ArrayList<>();
        System.out.println(taskRequestDTO.isWeeklyTask());
        if (taskRequestDTO.isWeeklyTask() == false) {
            TaskModel taskModelRequest = taskTransformer.transformTaskRequest(taskDTO);
            TaskModel taskModelResponse = taskService.checkPostTask(taskModelRequest);

            taskDTOS.add(taskTransformer.transformTaskResponse(taskModelResponse));
            return ResponseEntity.ok(taskDTOS);
        } else {
            List<TaskModel> taskModels = taskTransformer.transformTaskAllWeekRequest(taskDTO);
            System.out.println(taskModels);
            for (TaskModel taskModel: taskModels) {
                taskService.checkPostTask((taskModel));
                taskDTOS.add(taskTransformer.transformTaskResponse(taskModel));
            }

            return ResponseEntity.ok(taskDTOS);
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/tasks", method = RequestMethod.DELETE)
    public ResponseEntity <String> deleteAllTasks() {
        taskService.checkDeleteTasks();

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

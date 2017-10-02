package com.nassir.weekly.controller;

import com.nassir.weekly.domain.TaskModel;
import com.nassir.weekly.dto.TaskDTO;
import com.nassir.weekly.dto.TasksDTO;
import com.nassir.weekly.repository.TasksRepository;
import com.nassir.weekly.transformer.TasksTranformer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nassir on 9/21/17.
 */

@RestController
public class TaskController {

    @Autowired
    private TasksRepository tasksRepository;

    @RequestMapping("/tasks")
    public TasksDTO getTasks() {
        List<TaskDTO> tasks = new ArrayList<>();
        for (TaskModel taskModel : tasksRepository.findAll()) {
            tasks.add(TasksTranformer.tranform(taskModel));
        }

        return new TasksDTO(tasks);
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    public ResponseEntity <String> persistTask(@RequestBody TaskDTO task) {
        System.out.println("called");
        ModelMapper modelMapper = new ModelMapper();
        TaskModel taskModel = modelMapper.map(task, TaskModel.class);
        System.out.println(task.getDaysDTO());
        tasksRepository.save(taskModel);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}

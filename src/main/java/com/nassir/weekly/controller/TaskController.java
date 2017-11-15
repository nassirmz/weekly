package com.nassir.weekly.controller;

import com.nassir.weekly.domain.TaskModel;
import com.nassir.weekly.dto.TaskDTO;
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


@RestController
public class TaskController {

    @Autowired
    private TasksRepository tasksRepository;

    private ModelMapper modelMapper = new ModelMapper();

    private TasksTranformer tasksTranformer = new TasksTranformer();

    @RequestMapping("/tasks")
    public List<TaskDTO> getTasks() {
        List<TaskDTO> tasks = new ArrayList<>();
        for (TaskModel taskModel : tasksRepository.findAll()) {
            tasks.add(tasksTranformer.tranform(taskModel));
        }
        return tasks;
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    public ResponseEntity <String> persistTask(@RequestBody TaskDTO task) {
        TaskModel taskModel = modelMapper.map(task, TaskModel.class);
        
        tasksRepository.save(taskModel);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.DELETE)
    public ResponseEntity <String> deleteAllTasks() {
        tasksRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

package com.nassir.weekly.service;

import com.nassir.weekly.domain.TaskModel;
import com.nassir.weekly.repository.TasksRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.util.Collection;
import java.util.List;

@Service
public class TaskService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskService.class);

    private TasksRepository tasksRepository;

    @Autowired
    public TaskService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public TaskModel checkPostTask(TaskModel taskModel) {
        return tasksRepository.save(taskModel);
    }

    public Collection<TaskModel> checkGetTasks() {
        return tasksRepository.findAll();
    }

    public void checkDeleteTasks() {
        tasksRepository.deleteAll();
    }
}

package com.nassir.weekly.controller;

import com.nassir.weekly.WeeklyApplication;
import com.nassir.weekly.domain.TaskModel;
import com.nassir.weekly.repository.WeeklyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by nassir on 9/21/17.
 */

@RestController
public class TaskController {

    private Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private WeeklyRepository weeklyRepository;

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public ResponseEntity<Collection<TaskModel>> getTasks() {
        return new ResponseEntity<>(weeklyRepository.findAll(), HttpStatus.OK);
    }

}

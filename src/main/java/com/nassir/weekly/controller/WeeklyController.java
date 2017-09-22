package com.nassir.weekly.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nassir on 9/21/17.
 */

@RestController
public class WeeklyController {

    private Logger logger = LoggerFactory.getLogger(WeeklyController.class);

    @RequestMapping("/greeting")
    public String greeting() {
        return "Hello World";
    }

}

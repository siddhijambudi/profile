package com.resume.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sjambudi on 11/11/2018.
 */

@RestController
public class ResumeController {
    @RequestMapping("/")
    public String index() {
        return "Hello from spring boot application";
    }
    @RequestMapping("/api/v1/SiddhiJambudiResume/name")
    public String getName() {
        return "Siddhi Jambudi";
    }
}

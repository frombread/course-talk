package com.example.lastproject.controller;

import com.example.lastproject.entities.CourseEntity;
import com.example.lastproject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Set;

@Controller
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/course")
    public String getCourses(Model model, Principal principal) {
        if (principal != null) {
            String userId = principal.getName();
            Set<CourseEntity> courses = courseService.getCoursesByUserId(Long.valueOf(userId));
            model.addAttribute("courses", courses);
            return "success";
        }
        else{
            return "fail";
        }
    }
}

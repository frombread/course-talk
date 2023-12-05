package com.example.lastproject.controller;

import com.example.lastproject.dto.CourseDto;
import com.example.lastproject.entities.CourseEntity;
import com.example.lastproject.service.CourseService;
import com.example.lastproject.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Set;

@RestController
public class CourseController {
    private final CourseService courseService;
    private final UserSevice userSevice;


    @Autowired
    public CourseController(CourseService courseService, UserSevice userSevice) {
        this.courseService = courseService;
        this.userSevice = userSevice;
    }

    @GetMapping("/course")
    public ResponseEntity<?> getCourses(@RequestParam("token") String ynuNumber) {
        try {
            Integer ynunumber1= Integer.parseInt(ynuNumber);
            Long userId = userSevice.findUserIdByYnuNumber(ynunumber1);
            System.out.println(userId);
            if (userId == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
            }
            Set<CourseDto> courses = courseService.getCoursesByUserId(userId);
            return ResponseEntity.ok(courses);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve courses");
        }
    }
}

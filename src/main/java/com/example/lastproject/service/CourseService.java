package com.example.lastproject.service;

import com.example.lastproject.entities.CourseEntity;
import com.example.lastproject.entities.UserEntity;
import com.example.lastproject.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    @Autowired
    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    public Set<CourseEntity> getCoursesByUserId(Long userId) {
        UserEntity user = getUserById(userId);
        return user.getCourses();
    }

    private UserEntity getUserById(Long userId) {
        UserEntity user = new UserEntity();
        user.setUserId(userId);
        return user;
    }
}

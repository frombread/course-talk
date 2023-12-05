package com.example.lastproject.service;

import com.example.lastproject.dto.CourseDto;
import com.example.lastproject.entities.UserEntity;
import com.example.lastproject.repository.CourseRepository;
import com.example.lastproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, UserRepository userRepository){
        this.courseRepository = courseRepository;
        this.userRepository =userRepository;
    }

    public Set<CourseDto> getCoursesByUserId(Long userId) {
        UserEntity user = getUserById(userId);
        return user.getCourses().stream()
                .map(course -> new CourseDto(course.getCourseId(), course.getCourseName()))
                .collect(Collectors.toSet());
    }

    private UserEntity getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));    }
}

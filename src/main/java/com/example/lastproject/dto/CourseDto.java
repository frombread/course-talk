package com.example.lastproject.dto;

import lombok.Getter;

@Getter
public class CourseDto {
    private final Long courseId;
    private final String courseName;

    // 생성자, 게터, 세터 등 필요한 메서드를 추가합니다.

    // 예시: 생성자
    public CourseDto(Long courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }
}

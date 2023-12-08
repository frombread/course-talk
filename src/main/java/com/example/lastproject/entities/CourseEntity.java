package com.example.lastproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CourseEntity {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    @Setter
    @Getter
    private String courseName;
    @Setter
    @Getter
    private Integer courseNumber;
    @ManyToMany(mappedBy = "courses")
    private Set<UserEntity> users;

    @OneToMany(mappedBy = "course")
    private Set<ChatEntity> chats;

}

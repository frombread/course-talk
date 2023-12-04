package com.example.lastproject.entities;

import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    @Setter
    private String courseName;
    @Setter
    private Integer courseNumber;
    @ManyToMany(mappedBy = "courses")
    private Set<UserEntity> users;

    @OneToMany(mappedBy = "course")
    private Set<ChatEntity> chats;




//    public LectureEntity(){
//
//    }
}

package com.example.lastproject.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class LectureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lectureId;

    private String courseName;
    private Integer courseNumber;
    @ManyToMany(mappedBy = "lectures")
    private Set<UserEntity> users;

    @OneToMany(mappedBy = "course")
    private Set<ChatEntity> chats;
//    public LectureEntity(){
//
//    }
}

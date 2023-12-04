package com.example.lastproject.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class LeactureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lecture_id;

    private String course_name;
    private Number course_number;
    @ManyToMany(mappedBy = "lectures")
    private Set<UserEntity> users;

    @OneToMany(mappedBy = "course")
    private Set<ChatEntity> chats;

}

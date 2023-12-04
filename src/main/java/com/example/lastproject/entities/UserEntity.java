package com.example.lastproject.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String type;
    private Integer ynuNumber;
    private String passWord;
    @ManyToMany
    private Set<LectureEntity> lectures;

    @OneToMany(mappedBy = "user")
    private Set<ChatEntity> chats;
//    public UserEntity() {
//
//    }
//
    //get,set 추가해도됨
}

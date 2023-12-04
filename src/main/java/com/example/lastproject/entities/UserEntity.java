package com.example.lastproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
public class UserEntity {
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Setter
    private String name;
    @Setter
    private String type;
    @Setter
    private Integer ynuNumber;
    @Setter
    private String passWord;

    @Getter
    @Setter
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<CourseEntity> courses;

    @OneToMany(mappedBy = "user")
    private Set<ChatEntity> chats;

    //    public UserEntity() {
    //
    //    }
    //
}

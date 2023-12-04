package com.example.lastproject.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private String name;

    private String type;

    private Number ynu_number;
    @ManyToMany
    private Set<LeactureEntity> lectures;

    @OneToMany(mappedBy = "user")
    private Set<ChatEntity> chats;

    //get,set 추가해도됨
}

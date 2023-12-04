package com.example.lastproject.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ChatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chat_id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private LeactureEntity course;

    private String content;
    private LocalDateTime created_at;

}

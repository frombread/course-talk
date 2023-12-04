package com.example.lastproject.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ChatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatId;
    @ManyToOne
    private UserEntity user;

    @ManyToOne
    private LectureEntity course;
    private String content;
    private LocalDateTime createdAt;
//    public ChatEntity(){
//
//    }
}

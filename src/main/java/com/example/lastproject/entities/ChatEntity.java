package com.example.lastproject.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ChatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatId;
    @ManyToOne
    @JoinColumn(name = "userId") // 매핑할 외래키의 컬럼 이름
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "courseId") // 매핑할 외래키의 컬럼 이름
    private CourseEntity course;
    private String content;
    private LocalDateTime createdAt;
//    public ChatEntity(){
//
//    }
}

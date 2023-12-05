package com.example.lastproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ChatEntity {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @Setter
    @Getter
    @JoinColumn(name = "userId") // 매핑할 외래키의 컬럼 이름
    private UserEntity user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @Setter
    @Getter
    @JoinColumn(name = "courseId") // 매핑할 외래키의 컬럼 이름
    private CourseEntity course;

    @Setter
    @Getter
    private String content;
    @Setter
    @Getter
    private LocalDateTime createdAt;

}

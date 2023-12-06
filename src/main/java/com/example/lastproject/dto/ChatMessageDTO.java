package com.example.lastproject.dto;

import lombok.Getter;

import java.time.LocalDateTime;

public class ChatMessageDTO {
    private String userName;
    private String content;
    private LocalDateTime createdAt;
    @Getter
    private Long courseId;

    public ChatMessageDTO(String userName, String content, LocalDateTime createdAt,Long courseId) {
        this.userName = userName;
        this.content = content;
        this.createdAt = createdAt;
        this.courseId = courseId;
    }

    // Getter 메소드

    public String getUserName() {
        return userName;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}

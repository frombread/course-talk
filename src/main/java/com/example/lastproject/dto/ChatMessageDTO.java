package com.example.lastproject.dto;

import java.time.LocalDateTime;

public class ChatMessageDTO {

    private Long chatId;
    private String userName;
    private String content;
    private LocalDateTime createdAt;

    public ChatMessageDTO(Long chatId, String userName, String content, LocalDateTime createdAt) {
        this.chatId = chatId;
        this.userName = userName;
        this.content = content;
        this.createdAt = createdAt;
    }

    // Getter 메소드
    public Long getChatId() {
        return chatId;
    }

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

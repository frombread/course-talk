package com.example.lastproject.controller;

import com.example.lastproject.dto.ChatMessageDTO;
import com.example.lastproject.entities.ChatEntity;
import com.example.lastproject.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ChatController {
    private final ChatService chatService;
    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }
    @GetMapping("/chat/{courseId}")
    public List<ChatMessageDTO> getChatMessagesByCourseId(@PathVariable Long courseId) {
        return chatService.getChatMessagesForCourse(courseId);
    }
}

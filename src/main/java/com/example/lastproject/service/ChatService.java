package com.example.lastproject.service;
import com.example.lastproject.dto.ChatMessageDTO;
import com.example.lastproject.entities.ChatEntity;
import com.example.lastproject.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChatService {
    private final ChatRepository chatRepository;
    @Autowired
    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }
    public List<ChatMessageDTO> getChatMessagesForCourse(Long courseId) {
        List<ChatEntity> chatEntities = chatRepository.findByCourse_CourseId(courseId);

        return chatEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    private ChatMessageDTO convertToDTO(ChatEntity chatEntity) {
        return new ChatMessageDTO(
                chatEntity.getUser().getName(),
                chatEntity.getContent(),
                chatEntity.getCreatedAt(),
                chatEntity.getCourse().getCourseId()
        );
    }
}

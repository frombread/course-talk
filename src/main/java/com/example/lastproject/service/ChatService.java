package com.example.lastproject.service;
import com.example.lastproject.dto.ChatMessageDTO;
import com.example.lastproject.entities.ChatEntity;
import com.example.lastproject.entities.CourseEntity;
import com.example.lastproject.entities.UserEntity;
import com.example.lastproject.repository.ChatRepository;
import com.example.lastproject.repository.CourseRepository;
import com.example.lastproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChatService {
    private final ChatRepository chatRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;


    @Autowired
    public ChatService(ChatRepository chatRepository,UserRepository userRepository, CourseRepository courseRepository) {
        this.chatRepository = chatRepository;
        this.userRepository =userRepository;
        this.courseRepository=courseRepository;
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

    @Transactional
    public void saveChatMessage(Long userId, Long courseId, String msg) {
        System.out.println("dddd : "+ msg);
        Optional<UserEntity> userEntityOptional = userRepository.findById(userId);
        Optional<CourseEntity> courseEntityOptional = courseRepository.findById(courseId);

        ChatEntity chatEntity = new ChatEntity();
        chatEntity.setUser(userEntityOptional.get());
        chatEntity.setCourse(courseEntityOptional.get());
        chatEntity.setContent(msg);
        chatEntity.setCreatedAt(LocalDateTime.now());

        chatRepository.save(chatEntity);
    }
}

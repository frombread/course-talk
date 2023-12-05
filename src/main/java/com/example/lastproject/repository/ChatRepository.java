package com.example.lastproject.repository;

import com.example.lastproject.entities.ChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository extends JpaRepository<ChatEntity,Long> {
    List<ChatEntity> findByCourse_CourseId(Long courseId);

}

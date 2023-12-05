//package com.example.lastproject;
//
//import com.example.lastproject.entities.ChatEntity;
//import com.example.lastproject.entities.CourseEntity;
//import com.example.lastproject.entities.UserEntity;
//import com.example.lastproject.repository.ChatRepository;
//import com.example.lastproject.repository.CourseRepository;
//import com.example.lastproject.repository.UserRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import javax.transaction.Transactional;
//import java.time.LocalDateTime;
//import java.util.HashSet;
//import java.util.Set;
//
//@Component
//public class DataLoader implements CommandLineRunner {
//
//    private final UserRepository userRepository;
//    private final CourseRepository courseRepository;
//    private final ChatRepository chatRepository;
//
//    public DataLoader(UserRepository userRepository, CourseRepository courseRepository, ChatRepository chatRepository) {
//        this.userRepository = userRepository;
//        this.courseRepository = courseRepository;
//        this.chatRepository = chatRepository;
//    }
//    @Transactional
//    @Override
//    public void run(String... args) throws Exception {
//        UserEntity user1 = new UserEntity();
//        user1.setName("John Doe");
//        user1.setType("Student");
//        user1.setYnuNumber(123456);
//        user1.setPassWord("password123");
//
//        // 예시: 강의 생성
//        CourseEntity course1 = new CourseEntity();
//        course1.setCourseName("Introduction to Programming");
//        course1.setCourseNumber(101);
//
//        CourseEntity course2 = new CourseEntity();
//        course2.setCourseName("Database Management");
//        course2.setCourseNumber(201);
//
//        // 연관 관계 설정
//        Set<CourseEntity> courses = new HashSet<>();
//        courses.add(course1);
//        courses.add(course2);
//        user1.setCourses(courses);
//
//// 먼저 사용자 저장
//        userRepository.save(user1);
//
//// 사용자 저장 후에 강의 저장
//        courseRepository.save(course1);
//        courseRepository.save(course2);
//
//// ChatEntity에 대한 연관 관계 설정
//        ChatEntity chat1 = new ChatEntity();
//        chat1.setUser(user1);
//        chat1.setCourse(course1);
//        chat1.setContent("Hello, everyone!");
//        chat1.setCreatedAt(LocalDateTime.now());
//
//// ChatEntity 저장
//        chatRepository.save(chat1);
//
//    }
//}

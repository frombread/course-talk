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
//        user1.setName("방우현");
//        user1.setType("학생");
//        user1.setYnuNumber(21913683);
//        user1.setPassWord("dngus2ek!");
//
//        UserEntity user2 = new UserEntity();
//        user2.setName("이성균");
//        user2.setType("학생");
//        user2.setYnuNumber(21512125);
//        user2.setPassWord("tjdrbs2ek!");
//
//        // 예시: 강의 생성
//        CourseEntity course1 = new CourseEntity();
//        course1.setCourseName("알고리즘");
//        course1.setCourseNumber(1259);
//
//        CourseEntity course2 = new CourseEntity();
//        course2.setCourseName("데이터 베이스");
//        course2.setCourseNumber(1260);
//
//        CourseEntity course3 = new CourseEntity();
//        course3.setCourseName("컴퓨터 네트워크");
//        course3.setCourseNumber(1261);
//
//        CourseEntity course4 = new CourseEntity();
//        course4.setCourseName("객체지향과 자료구조");
//        course4.setCourseNumber(1263);
//
//        CourseEntity course5 = new CourseEntity();
//        course5.setCourseName("인공지능");
//        course5.setCourseNumber(1264);
//
//        // 연관 관계 설정
//        Set<CourseEntity> courses1 = new HashSet<>();
//        Set<CourseEntity> courses2 = new HashSet<>();
//
//        courses1.add(course1);
//        courses1.add(course2);
//        courses1.add(course4);
//        courses1.add(course5);
//        user1.setCourses(courses1);
//
//        courses2.add(course1);
//        courses2.add(course3);
//        user2.setCourses(courses2);
//
//// 먼저 사용자 저장
//        userRepository.save(user1);
//        userRepository.save(user2);
//
//// 사용자 저장 후에 강의 저장
//        courseRepository.save(course1);
//        courseRepository.save(course2);
//        courseRepository.save(course3);
//        courseRepository.save(course4);
//        courseRepository.save(course5);
//
//
//// ChatEntity에 대한 연관 관계 설정
//        ChatEntity chat1 = new ChatEntity();
//        chat1.setUser(user1);
//        chat1.setCourse(course1);
//        chat1.setContent("나이스요~");
//        chat1.setCreatedAt(LocalDateTime.now());
//
//// ChatEntity 저장
//        chatRepository.save(chat1);
//
//    }
//}

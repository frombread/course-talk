package com.example.lastproject.repository;

import com.example.lastproject.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByYnuNumberAndPassWord(Integer ynuNumber, String passWord);

    Optional<Object> findByYnuNumber(Integer ynuNumber);
    Optional<UserEntity> findByUserId(Long userId);

}

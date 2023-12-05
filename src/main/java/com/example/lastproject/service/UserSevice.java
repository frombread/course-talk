package com.example.lastproject.service;

import com.example.lastproject.entities.UserEntity;
import com.example.lastproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserSevice {
    private final UserRepository userRepository;

    @Autowired
    public UserSevice(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public boolean authenticate(Integer ynuNumber, String password) {
        UserEntity userEntity = userRepository.findByYnuNumberAndPassWord(ynuNumber, password).orElse(null);

        if (userEntity != null) {
            return true;
        } else {
            return false;
        }
    }
    public Long findUserIdByYnuNumber(Integer ynuNumber) {
        Optional<Object> userOptional = userRepository.findByYnuNumber(ynuNumber);
        if (userOptional.isPresent()) {
            UserEntity userEntity = (UserEntity) userOptional.get();
            return userEntity.getUserId();
        } else {
            return null;
        }
    }
}
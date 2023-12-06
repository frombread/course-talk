package com.example.lastproject.service;

import com.example.lastproject.dto.UserDTO;
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
    public Optional<UserDTO> authenticate(Integer ynuNumber, String password) {
        Optional<UserEntity> userEntityOptional = userRepository.findByYnuNumberAndPassWord(ynuNumber, password);

        return userEntityOptional.map(userEntity ->
                new UserDTO(userEntity.getUserId(), userEntity.getName(),userEntity.getYnuNumber())
        );
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
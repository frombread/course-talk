package com.example.lastproject.controller;

import com.example.lastproject.dto.UserInfoDTO;
import com.example.lastproject.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SignUpController {
    private final UserSevice userSevice;
    @Autowired
    public SignUpController(UserSevice userSevice){
        this.userSevice =userSevice;
    }

    @PostMapping("/signup")
    public Optional<UserInfoDTO> signup(@RequestBody UserInfoDTO userInfoDTO){
        return userSevice.signUp(userInfoDTO.getName(),userInfoDTO.getPassword(),userInfoDTO.getType(),userInfoDTO.getYnuNumber());
    }
}

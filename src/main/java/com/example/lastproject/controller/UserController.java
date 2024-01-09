package com.example.lastproject.controller;

import com.example.lastproject.dto.UserDTO;
import com.example.lastproject.dto.UserInfoDTO;
import com.example.lastproject.dto.UserLoginDTO;
import com.example.lastproject.entities.UserEntity;
import com.example.lastproject.service.UserSevice;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {
    private final UserSevice userService;
    @Autowired
    public UserController(UserSevice userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDTO userLoginDTO) {
        Optional<UserDTO> userInfoOptional = userService.authenticate(userLoginDTO.getYnuNumber(), userLoginDTO.getPassword());

        if (userInfoOptional.isPresent()) {
            UserDTO userInfo = userInfoOptional.get();
            Map<String, String> tokenMap = new HashMap<>();
            tokenMap.put("userToken", String.valueOf(userInfo.getYnuNumber()));
            tokenMap.put("userId", String.valueOf(userInfo.getUserId()));
            tokenMap.put("userName", userInfo.getUserName());
            return ResponseEntity.ok(tokenMap);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @GetMapping("/user")
    public ResponseEntity<?> mypage(@RequestParam("token") String ynuNumber) {
        try {
            Integer ynunumber1= Integer.parseInt(ynuNumber);
            System.out.println(ynunumber1);
            Long userId = userService.findUserIdByYnuNumber(ynunumber1);

            UserInfoDTO userInfoDTO = userService.getUserInfoByToken(userId);


            if (userInfoDTO != null) {
                return ResponseEntity.ok(userInfoDTO);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error retrieving user information");
        }
    }


}

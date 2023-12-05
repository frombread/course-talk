package com.example.lastproject.controller;

import com.example.lastproject.dto.UserLoginDTO;
import com.example.lastproject.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserSevice userService;
    @Autowired
    public UserController(UserSevice userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginDTO userLoginDTO) {
        boolean isAuthenticated = userService.authenticate(userLoginDTO.getYnuNumber(), userLoginDTO.getPassword());

        if (isAuthenticated) {
            String token = String.valueOf(userLoginDTO.getYnuNumber());

            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}

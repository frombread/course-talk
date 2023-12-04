package com.example.lastproject.controller;

import com.example.lastproject.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private final UserSevice userSevice;
    @Autowired
    public UserController(UserSevice userSevice) {
        this.userSevice = userSevice;
    }
    @GetMapping("/login")
    public String loginForm() {
        return "login.html";
    }
    @PostMapping("/login")
    public String login(@RequestParam("ynuNumber") Integer ynuNumber, @RequestParam("password") String password, Model model) {
        boolean isAuthenticated = userSevice.authenticate(ynuNumber, password);
        if (isAuthenticated) {
            return "success";
        } else {
            System.out.println(ynuNumber);
            System.out.println(password);
            model.addAttribute("error", "Invalid credentials");
            return "login.html";
        }
    }
}

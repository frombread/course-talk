package com.example.lastproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @GetMapping("/user/save")
    public String saveForm(){
        return "save.html";
    }

    @PostMapping("/user/save")
    public String save(@RequestParam("id") String id,
                       @RequestParam("password") String password,
                       @RequestParam("name") String name) {
        System.out.println("UserController.save");
        System.out.println("ID: " + id);
        System.out.println("Password: " + password);
        System.out.println("Name: " + name);

        return "index.html";
    }
}
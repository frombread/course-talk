package com.example.lastproject.controller;


import com.example.lastproject.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MailController {

    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }
    @PostMapping("/mail")
    public String mailSend(@RequestBody Map<String, String> requestBody) {
        System.out.println(requestBody.get("email"));
        String mail = requestBody.get("email");
        int number = mailService.sendMail(mail);
        String num = "" + number;
        return num;
    }
}
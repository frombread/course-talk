package com.example.lastproject.dto;

import lombok.Getter;

public class UserInfoDTO {
    @Getter
    private Long userId;
    @Getter
    private String name;
    @Getter
    private String type;
    @Getter
    private Integer ynuNumber;
    @Getter
    private String password;

    public UserInfoDTO() {
    }

    public UserInfoDTO(Long userId, String name, String type, Integer ynuNumber, String password) {
        this.userId = userId;
        this.name = name;
        this.type = type;
        this.ynuNumber = ynuNumber;
        this.password = password;
    }

    public UserInfoDTO(String name, Long userId, Integer ynuNumber) {
        this.name = name;
        this.userId = userId;
        this.ynuNumber = ynuNumber;
    }

    // Getters and setters for other fields

    // You can generate these methods using your IDE or write them manually

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setYnuNumber(Integer ynuNumber) {
        this.ynuNumber = ynuNumber;
    }

    // Add getters and setters for other fields as needed
}

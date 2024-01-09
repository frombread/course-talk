package com.example.lastproject.dto;

public class UserInfoDTO {
    private Long userId;
    private String name;
    private String type;
    private Integer ynuNumber;

    // Constructors, getters, and setters

    public UserInfoDTO() {
    }

    public UserInfoDTO(Long userId, String name, String type, Integer ynuNumber) {
        this.userId = userId;
        this.name = name;
        this.type = type;
        this.ynuNumber = ynuNumber;
    }

    // Getters and setters for other fields

    // You can generate these methods using your IDE or write them manually

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getYnuNumber() {
        return ynuNumber;
    }

    public void setYnuNumber(Integer ynuNumber) {
        this.ynuNumber = ynuNumber;
    }

    // Add getters and setters for other fields as needed
}

package com.example.lastproject.dto;

import lombok.Getter;

@Getter
public class UserDTO {
    private final Long userId;
    private Integer ynuNumber;
    //    private Integer ynuNumber;
//    private String password;
    private final String userName;

    public UserDTO(Long userId, String userName,Integer ynuNumber) {
        this.userId = userId;
        this.userName = userName;
        this.ynuNumber=ynuNumber;
    }

}

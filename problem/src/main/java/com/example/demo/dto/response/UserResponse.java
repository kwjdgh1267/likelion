package com.example.demo.dto.response;

import lombok.Getter;

@Getter
public class UserResponse {
    private  Long id;
    private String name;
    private Integer age;

    public UserResponse(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

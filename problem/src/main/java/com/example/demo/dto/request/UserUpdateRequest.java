package com.example.demo.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserUpdateRequest {
    private Long id;
    private String name;
}

package com.example.demo.domain.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id =null;

    @Column(nullable = false,length = 25)
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    //    public User(String name, Integer age){
//        if(name ==null || name.isBlank()){
//            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다.",name));
//        }
//
//    }
}

package com.example.demo.controller.user;


import com.example.demo.dto.CalculatorRequest;
import com.example.demo.dto.request.UserCreateRequest;
import com.example.demo.dto.request.UserUpdateRequest;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.service.user.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//api 만들거다
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }
    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request){
        userService.saveUser(request);
    }
    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name){
        userService.deleteUser(name);
    }
    @GetMapping("/user")
    public List<UserResponse> getUsers(){
        return userService.getUsers();
    }

    //질문: 같은 url에 GetMapping이라도 파라미터가 다르면 따로 작동 가능한지?
    //안된다.
//    @GetMapping("/user")
//    public UserResponse getUser(@RequestParam String name){
//        return userService.getUser(name);
//    }
    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest dto){
        userService.updateUser(dto);

    }



}
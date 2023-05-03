package com.example.demo.service.user;

import com.example.demo.domain.user.User;
import com.example.demo.dto.request.UserCreateRequest;
import com.example.demo.dto.request.UserUpdateRequest;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.repository.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void saveUser(UserCreateRequest request){
        userRepository.save(new User(request.getName(),request.getAge()));
    }
    public void deleteUser(String name){
        User user=userRepository.findByName(name).orElseThrow(()->new IllegalArgumentException());
        userRepository.delete(user);
    }

    public List<UserResponse> getUsers() {
         return userRepository.findAll().stream().map(user ->new UserResponse(user.getId(), user.getName(), user.getAge())).collect(Collectors.toList());
    }

    public void updateUser(UserUpdateRequest dto) {
        User user = userRepository.findById(dto.getId()).orElseThrow(() -> new IllegalArgumentException());
        user.setName(dto.getName());
        userRepository.save(user);
    }


//    public UserResponse getUser(String name) {
//        User user= userRepository.findByName(name).orElseThrow(()->new IllegalArgumentException());
//        return new UserResponse(user.getId(),user.getName(),user.getAge());
//    }


}

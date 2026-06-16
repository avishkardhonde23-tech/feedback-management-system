package com.example.practicee.controller;

import com.example.practicee.dto.LoginRequest;
import com.example.practicee.entity.UserEntity;
import com.example.practicee.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public UserEntity register(@Valid @RequestBody UserEntity user){
        return userService.registerUser(user);
    }
    @PostMapping("/login")
    public UserEntity login(@RequestBody LoginRequest request){
        return userService.login(
                request.getEmail(),
                request.getPassword()
        );
    }
}

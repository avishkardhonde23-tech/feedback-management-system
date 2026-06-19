package com.example.practicee.service;

import com.example.practicee.entity.UserEntity;
import com.example.practicee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository uRepo;

    public UserEntity registerUser(UserEntity user){
        if(uRepo.findByEmail(user.getEmail()).isPresent()){
            throw new RuntimeException("Email already registered");
        }
        user.setRole("USER");
        return uRepo.save(user);
    }

    public UserEntity login(String email,String password ) {
        UserEntity user = uRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid Password");
        }
        return user;
    }

}

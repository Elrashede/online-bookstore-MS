package com.example.onlinebookstore.service;

import com.example.onlinebookstore.model.User;
import com.example.onlinebookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> findUserByUsername(String userName){
           return userRepository.findByUsername(userName);
    }
}

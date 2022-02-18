package com.example.socialnetwork.services;

import com.example.socialnetwork.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    UserService userService;

    public User login(String login, String password){
        return userService.getUserByEmailAndPassword(login, password);
    }
}

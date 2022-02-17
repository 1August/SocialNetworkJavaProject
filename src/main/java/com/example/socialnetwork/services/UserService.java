package com.example.socialnetwork.services;

import com.example.socialnetwork.repository.UserRepository;
import com.example.socialnetwork.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    UserRepository userRepository;

//    public List<User> findAllUsers() {
//        return userRepository.findAll();
//    }

    public User getUserById(Integer userId){
        return userRepository.getUserById(userId);
    }

    public User getUserByEmail(String email){
        return userRepository.getUserByEmail(email);
    }
}
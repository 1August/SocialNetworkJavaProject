package com.example.socialnetwork.services;

import com.example.socialnetwork.entities.User;

public interface IUserService {
//    List<User> findAllUsers();

    User getUserById(Integer userId);
    User getUserByEmail(String email);
}
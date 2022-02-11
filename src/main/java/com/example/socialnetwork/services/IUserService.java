package com.example.socialnetwork.services;
import java.util.List;
import com.example.socialnetwork.models.User;
public interface IUserService {
    List<User> findAllUsers();
}
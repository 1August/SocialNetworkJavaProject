
package com.example.socialnetwork.services;
import com.example.socialnetwork.repository.UserRepository;
import com.example.socialnetwork.models.User;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
public class UserService implements IUserService{
    @Autowired
    UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
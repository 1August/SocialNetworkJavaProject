package com.example.socialnetwork.services;

import com.example.socialnetwork.repository.UserRepository;
import com.example.socialnetwork.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    UserRepository userRepository;

    public User saveUser(User newUser) {
        User user = userRepository.save(newUser);
        return user;
    }

    public void addFriend(Integer user1_id, Integer user2_id) throws Exception{

        if(user1_id != null && user1_id.equals(user2_id)) {
            throw new Exception("We can not add same users");
        }
        User user = userRepository.getUserById(user1_id);
        User friend = userRepository.getUserById(user2_id);

        user.addFriend(friend);
        userRepository.save(friend);
    }

    public User getUserById(Integer userId){
        return userRepository.getUserById(userId);
    }

    public User getUserByEmail(String email){
        return userRepository.getUserByEmail(email);
    }





}
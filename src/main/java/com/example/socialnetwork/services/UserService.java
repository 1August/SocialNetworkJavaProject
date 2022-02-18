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
//


    public User saveUser(User newUser) {
        User user = userRepository.save(newUser);
        return user;
    }




    public boolean addFriendToUser(Integer userId, Integer friendId) {
        User user = userRepository.getUserById(userId);
        User friend = userRepository.getUserById(friendId);
        return userRepository.addFriendToUser(user, friend);
//
////        Optional<User> userOptional = userRepo.findById((int) userId.longValue());
////        User user = userOptional.orElse(null);
////        if (user == null) {
////            return false;
////        }
//    }

    public User getUserById(Integer userId){
        return userRepository.getUserById(userId);
    }

    public User getUserByEmail(String email){
        return userRepository.getUserByEmail(email);
    }





}
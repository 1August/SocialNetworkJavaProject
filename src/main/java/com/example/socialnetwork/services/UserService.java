package com.example.socialnetwork.services;

import com.example.socialnetwork.entities.Post;
import com.example.socialnetwork.repository.UserRepository;
import com.example.socialnetwork.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PostService postService;

    public User saveUser(User newUser) {
        User user = userRepository.save(newUser);
        return user;
    }


    public void addFriend(Integer userId, Integer friendId) throws Exception {
        if (userId == null || friendId == null) throw new Exception("User is null");
        if (userId.equals(friendId)) throw new Exception("Can not add same user");

        User user = userRepository.getUserById(userId);
        User friend = userRepository.getUserById(friendId);
        user.addFriend(friend);

        userRepository.save(user);
        userRepository.save(friend);
    }

    public Post savePostInUser(Integer userId, Post post) {
        User user = userRepository.getUserById(userId);
//        Post postSaved = postService.savePost(post);

        user.addPostToUser(post);
        return post;
    }

    public User getUserById(Integer userId) {
        return userRepository.getUserById(userId);
    }

    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }


}
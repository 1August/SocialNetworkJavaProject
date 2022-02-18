package com.example.socialnetwork.services;

import com.example.socialnetwork.entities.Post;
import com.example.socialnetwork.repository.PostRepository;
import com.example.socialnetwork.repository.UserRepository;
import com.example.socialnetwork.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User saveUser(User newUser) throws Exception {
        if (userRepository.getUserByEmail(newUser.getEmail()) != null) throw new Exception("Login exists!");
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

    public User getUserById(Integer userId) {
        return userRepository.getUserById(userId);
    }

    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    public Post savePostInUser(Post post) {
        User user = userRepository.getUserById(post.getAuthorId().getId());

        postRepository.save(post);
        return post;
    }

    public User getUserByEmailAndPassword(String email, String password){
        return userRepository.getUserByEmailAndPassword(email, password);
    }
}
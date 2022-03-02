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

    public User getUserById(Integer userId) {
        return userRepository.getUserById(userId);
    }

    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    public Post savePostInUser(Post post) throws Exception {
        User user = userRepository.getUserById(post.getAuthor().getId());

        if (postRepository.getPostByAuthorIdAndTitle(post.getAuthor().getId(), post.getTitle()) != null)
            throw new Exception("Post already exists");

        user.getPosts().add(postRepository.save(post));
        userRepository.save(user);
        return postRepository.getPostByAuthorIdAndTitle(user.getId(), post.getTitle());
    }

    public User getUserByEmailAndPassword(String email, String password){
        return userRepository.getUserByEmailAndPassword(email, password);
    }
}
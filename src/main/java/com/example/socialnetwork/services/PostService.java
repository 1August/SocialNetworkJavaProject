package com.example.socialnetwork.services;

import com.example.socialnetwork.models.Post;
import com.example.socialnetwork.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }
    public List<Post> findPostById(Integer id){
        return (List<Post>) postRepository.findPostById(id);
    }

    public Post savePost(Post newPost) {
        Post post = postRepository.save(newPost);
        return post;
    }
/*
    public Post deletePost(Integer id) {
        Optional <Post> retrievedPost = postRepository.findPostById(id);
        if (retrievedPost == null) {
            try {
                throw new Exception("Post not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
            postRepository.deleteById(id);
            return retrievedPost.get();
        }
    }*/
}

package com.example.socialnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.socialnetwork.models.Post;

public interface PostRepository extends JpaRepository<Post,Integer> {
    Post findPostById(Integer id);
    Post findPostByAuthor(String author);
}

package com.example.socialnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.socialnetwork.entities.Post;

public interface PostRepository extends JpaRepository<Post,Integer> {

    Post getPostByTitle(String title);
    Post getPostById(Integer id);
    Post getPostByAuthor(String email);
}

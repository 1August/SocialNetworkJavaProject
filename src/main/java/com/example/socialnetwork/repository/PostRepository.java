package com.example.socialnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.socialnetwork.entities.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {
    Post getPostByTitle(String title);
    Post getPostById(Integer id);
    Post getPostByAuthorId(Integer userId);
    List<Post> getAllByAuthorId(Integer userId);
    Post getPostByAuthorIdAndTitle(Integer authorId, String title);
}

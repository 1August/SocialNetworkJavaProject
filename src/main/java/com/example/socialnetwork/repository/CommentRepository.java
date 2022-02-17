package com.example.socialnetwork.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.socialnetwork.entities.Comment;

public interface CommentRepository  extends JpaRepository <Comment, Integer>  {
    Comment findCommentById(Integer id);
    Comment findCommentByAuthor(String author);
}

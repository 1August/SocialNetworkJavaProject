package com.example.socialnetwork.services;

import com.example.socialnetwork.entities.Comment;

import com.example.socialnetwork.entities.Post;
import com.example.socialnetwork.repository.CommentRepository;
import com.example.socialnetwork.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    public Comment saveComment(Comment comment) {
        commentRepository.save(comment);
        return comment;
    }

    public Comment getCommentByAuthor(String author){
        return  commentRepository.findCommentByAuthor(author);
    }

    public Comment getCommentById(Integer id){
        return  commentRepository.findCommentById(id);
    }



}

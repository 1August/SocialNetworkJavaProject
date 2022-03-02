package com.example.socialnetwork.services;

import com.example.socialnetwork.entities.Comment;

import com.example.socialnetwork.entities.Post;
import com.example.socialnetwork.entities.User;
import com.example.socialnetwork.repository.CommentRepository;
import com.example.socialnetwork.repository.PostRepository;
import com.example.socialnetwork.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CommentService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

//    public Comment saveComment(Integer postId, Comment comment) {
////        Comment commentSaved = commentRepository.save(comment);
//
//        Post post = postRepository.getPostById(postId);
//        User user = userRepository.getUserById(post.getAuthor().getId());
//
//        commentRepository.save(comment);
//        for (Post userPost : user.getPosts()) {
//            if(userPost.equals(post)){
//                userPost.getComments().add(comment);
//            }
//        }
//
////        post.getComments().add(commentRepository.save(comment));
//
//        userRepository.save(user);
//
//        return comment;
//    }

    public Comment getCommentByAuthorId(String author){
        return  commentRepository.getCommentByAuthorId(author);
    }

    public Comment getCommentById(Integer id){
        return  commentRepository.getCommentById(id);
    }
}

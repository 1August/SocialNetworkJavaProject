package com.example.socialnetwork.services;

import com.example.socialnetwork.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentService {
    @Autowired
    CommentRepository commentRepository;
}

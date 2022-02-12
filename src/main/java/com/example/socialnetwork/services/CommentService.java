package com.example.socialnetwork.services;

import com.example.socialnetwork.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CommentService {
    @Autowired
    CommentRepository commentRepository;
}

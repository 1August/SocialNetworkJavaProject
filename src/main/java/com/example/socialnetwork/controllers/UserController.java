package com.example.socialnetwork.controllers;


import com.example.socialnetwork.entities.Post;
import com.example.socialnetwork.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    PostService postService;

    @GetMapping
    String indexGet(){
        return "userProfile";
    }

    @GetMapping("/newPost")
    public String newPostGet(Model model){
        Post post=new Post();
        model.addAttribute("post",post);
        return "addPost";
    }

    @PostMapping("/add")
    public String newPostPost(Post post){
        postService.savePost(post);
        return "redirect:/user";
    }
}

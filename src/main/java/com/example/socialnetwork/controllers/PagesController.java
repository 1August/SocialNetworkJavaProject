package com.example.socialnetwork.controllers;

import com.example.socialnetwork.models.Post;
import com.example.socialnetwork.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PagesController {
    @Autowired
    PostService postService;

    @GetMapping("/posts")
    public String viewHomePage(Model model) {
        List<Post> posts = postService.findAllPosts();
        model.addAttribute("posts", posts);
        return "userProfile";
    }

    @RequestMapping("/new")
    public String newPost(Model model){
        Post post=new Post();
        model.addAttribute("post",post);
        return "addPost";
    }

    @PostMapping("/add")
    public String addPost(Post post){
        postService.savePost(post);
        return "redirect:/";
    }
    @GetMapping("/")
    String indexGet(){
        return "userProfile";
    }
}
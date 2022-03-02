package com.example.socialnetwork.controllers;


import com.example.socialnetwork.entities.Post;
import com.example.socialnetwork.entities.User;
import com.example.socialnetwork.services.PostService;
import com.example.socialnetwork.services.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;

@Controller
@RequestMapping("/user/{id}")
public class UserController {

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    //    Current logged in user
    User user = null;


    @GetMapping
    String userGet(Model model, @PathVariable Integer id) {
//        System.out.println("-----------");
        user = userService.getUserById(id);

        model.addAttribute("user", user);
        System.out.println("userGet is load and returned to template" + '\n' + user);

//        -------------------------------------------------------------
//        -------------------------------------------------------------
//        -------------------------------------------------------------
//        -------------------------------------------------------------
//        -------------------------------------------------------------
//        -------------------------------------------------------------
//        -------------------------------------------------------------
        System.err.println("Пост не сохраняется у юзера почему то, нужно проверить");
//        -------------------------------------------------------------
//        -------------------------------------------------------------
//        -------------------------------------------------------------
//        -------------------------------------------------------------
//        -------------------------------------------------------------
//        -------------------------------------------------------------
//        -------------------------------------------------------------




//        System.out.println(user);

//        System.out.println(user.getPosts().get(0).getTitle());

        return "userProfile";
    }

//    @GetMapping("/newPost")
//    public String newPostGet(Model model, @PathVariable Integer id) {
////        Post post = new Post();
////        model.addAttribute("post",post);
//
//        model.addAttribute("user", user);
//
//        return "";
//    }

//    !!! Need to add in MessageController !!! - method /post
//    @PostMapping("/addPost")
//    public String newPostPost(Post post){
////        userService.savePostInUser
//        postService.savePost(post);
//        return "redirect:/user";
//    }

    @PostMapping("/addFriend/{friendId}")
    public String addFriendToUser(@PathVariable Integer id, @PathVariable Integer friendId, Model model) throws Exception {
        userService.addFriend(id, friendId);
        model.addAttribute("user", user);

        return "redirect:/user/" + id;
    }
}

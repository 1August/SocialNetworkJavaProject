package com.example.socialnetwork.controllers;

import com.example.socialnetwork.entities.User;
import com.example.socialnetwork.services.PostService;
import com.example.socialnetwork.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class PagesController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    String indexGet() throws Exception {
        userService.saveUser(new User("Maks", "K", "e@example.com", "123"));
        userService.saveUser(new User("Akbala", "T", "e2@example.com", "123"));
        userService.saveUser(new User("Olzh", "O", "e3@example.com", "123"));

        User user = userService.getUserByEmail("e@example.com");
        User user2 = userService.getUserByEmail("e2@example.com");
        User user3 = userService.getUserByEmail("e3@example.com");

        userService.addFriend(user.getId(), user2.getId());
        userService.addFriend(user.getId(), user3.getId());

        return "redirect:/user/" + user.getId();
    }

    @GetMapping("/user/{id}/friend/{friendId}")
    String visitFriendGet(@PathVariable Integer id, @PathVariable Integer friendId, Model model){
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("friendInfo", userService.getUserById(friendId));

        return "userProfile";
    }
}
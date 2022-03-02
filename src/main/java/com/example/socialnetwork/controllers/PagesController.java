package com.example.socialnetwork.controllers;

import com.example.socialnetwork.entities.User;
import com.example.socialnetwork.services.LoginService;
import com.example.socialnetwork.services.PostService;
import com.example.socialnetwork.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping
public class PagesController {
    @Autowired
    UserService userService;

    @Autowired
    LoginService loginService;

    @GetMapping("/")
    String indexGet(Model model) throws Exception {


//        userService.saveUser(new User("Maks", "K", "e@example.com", "123"));
//        userService.saveUser(new User("Akbala", "T", "e2@example.com", "123"));

//        userService.saveUser(new User("Olzh", "O", "e3@example.com", "123"));
//
//        User user = userService.getUserByEmail("e@example.com");
//        User user2 = userService.getUserByEmail("e2@example.com");
//        User user3 = userService.getUserByEmail("e3@example.com");
//
//        userService.addFriend(user.getId(), user2.getId());
//        userService.addFriend(user.getId(), user3.getId());

        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);

        return "index";
    }

    @GetMapping("/users")
    String userGet(@PathVariable Integer userId, Model model){
        return "friends";
    }

    @GetMapping("/user/{id}/friend/{friendId}")
    String visitFriendGet(@PathVariable Integer id, @PathVariable Integer friendId, Model model){
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("friendInfo", userService.getUserById(friendId));

        return "userProfile";
    }

    @GetMapping("/login")
    String loginGet(){
        return "loginPage";
    }

    @PostMapping("/login")
    String loginPost(@PathParam("email") String email, @PathParam("password") String password) throws Exception {
        User user = loginService.login(email, password);
        if (user == null) throw new Exception("Error with login");
        return "redirect:/user/" + user.getId();
    }

    @GetMapping("/register")
    String registerGet(){
        return "registerPage";
    }

    @PostMapping("/register")
    String registerPost(@PathParam("name") String name, @PathParam("surname") String surname, @PathParam("email") String email, @PathParam("password") String password) throws Exception {
        User user = userService.saveUser(new User(name, surname, email, password));

        if (user == null) throw new Exception("Error with register");
        return "redirect:/user/" + user.getId();
    }

    @GetMapping("/logout")
    String logoutGet(){
        return "redirect:/";
    }
}
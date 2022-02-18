package com.example.socialnetwork.controllers;

import com.example.socialnetwork.entities.Post;
import com.example.socialnetwork.models.ResponsePost;
import com.example.socialnetwork.services.CommentService;
import com.example.socialnetwork.services.PostService;
import com.example.socialnetwork.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.socialnetwork.entities.User;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Controller
public class MessageController {

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;
    @Autowired
    CommentService commentService;

    @MessageMapping("/post")
    void processPost(@Payload ResponsePost responsePost){
        System.out.println(responsePost);

      //  userService.getUserByEma(post.getAuthor().getId());
        //postService.savePost(post);*/
        userService.getUserByEmail(responsePost.getEmail());
        User user =  userService.getUserByEmail(responsePost.getEmail());
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
        LocalDate localDate = LocalDate.now();
        Date date = Date.from(Instant.from(localDate));
        Post post = new Post(user, responsePost.getTitle(),responsePost.getContent(), date, null, "1111", true);
        postService.savePost(post);
    }



   @MessageMapping("/{postId}/comment")
    void processComment(@PathVariable Integer postId, ResponsePost responsePost, Model model){
        model.addAttribute("post","posts" );
        System.out.println(responsePost);
        commentService.getCommentByAuthor(responsePost.getEmail());
        User user =  userService.getUserByEmail(responsePost.getEmail());
//       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
        LocalDate localDate = LocalDate.now();
        Date date = Date.from(Instant.from(localDate));
        Post post = new Post(user, responsePost.getTitle(),responsePost.getContent(), date, null, "1111", true);
        postService.savePost(post);
    }


    @GetMapping("/ws")
    String websocketGet(){
        return "WebSocketConnection";
    }






}


//package com.example.socialnetwork.controllers;
//import com.example.socialnetwork.entities.Post;
//import com.example.socialnetwork.models.ResponsePost;
//
//import com.example.socialnetwork.services.PostService;
//import com.example.socialnetwork.services.UserService;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.messaging.handler.annotation.SendTo;
//
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.util.HtmlUtils;
//
//
//@Controller
//public class MessageController {
//
//    @Autowired
//    UserService userService;
//
//    @Autowired
//    PostService postService;
//
//
//    @MessageMapping("/user/post")
//    @SendTo("/topic/user/posts")
//    public ResponsePost getPost(String obj) throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.readValue(obj, ResponsePost.class);
//    }
//
//    @MessageMapping("/post")
//    void processPost(@Payload Post post){
//        userService.getUserById(post.getAuthor().getId());
//        postService.savePost(post);
//    }
//
//    @GetMapping("/websocket")
//    String websocketGet(){
//        return "WebSocketConnection";
//    }
//}

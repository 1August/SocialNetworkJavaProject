package com.example.socialnetwork.controllers;

import com.example.socialnetwork.entities.Post;
import com.example.socialnetwork.services.PostService;
import com.example.socialnetwork.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @MessageMapping("/chat")
    void processPost(@Payload Post post){
        userService.getUserById(post.getAuthor().getId());
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

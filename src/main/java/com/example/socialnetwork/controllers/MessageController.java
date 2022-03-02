package com.example.socialnetwork.controllers;

import com.example.socialnetwork.entities.Comment;
import com.example.socialnetwork.entities.Post;
import com.example.socialnetwork.models.ResponseComment;
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
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.socialnetwork.entities.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

@Controller
@RequestMapping

public class MessageController {

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;

    @MessageMapping("/post")
    @SendTo("/user/1")
    void processPost(@Payload ResponsePost responsePost){
        User user = userService.getUserByEmail(responsePost.getEmail());


//        LocalDate localDate = LocalDate.now();
//        Date date = Date.from(Instant.from(localDate));

        long millis = System.currentTimeMillis();
        Date date = new Date(millis);

        Post post = new Post(user.getId(), responsePost.getTitle(), responsePost.getContent(), date);

        System.out.println(post);

        userService.savePostInUser(post);

//        user = userService.getUserByEmail(responsePost.getEmail());
//        System.out.println(user);


//        List<Post> posts = postService.getPostsOfUser(user.getId());
//        model.addAttribute("user", user);

    }

   @MessageMapping("/{postId}/comment")
    void processComment(@PathVariable Integer postId, ResponseComment responseComment, Model model){
        model.addAttribute("post","posts"); // posts need to change for real posts

        User user = userService.getUserByEmail(responseComment.getEmail());
        Post post = postService.getPostById(postId);

//        LocalDate localDate = LocalDate.now();
//        Date date = Date.from(Instant.from(localDate));

       long millis = System.currentTimeMillis();
       Date date = new Date(millis);

        Comment comment = new Comment(user.getId(),responseComment.getContent(),date);
        commentService.saveComment(post.getId(), comment);
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

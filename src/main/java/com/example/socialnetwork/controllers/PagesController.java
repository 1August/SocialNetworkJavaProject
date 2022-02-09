package com.example.socialnetwork.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PagesController {
    @GetMapping("/")
    String indexGet(){
        return "index";
    }
}
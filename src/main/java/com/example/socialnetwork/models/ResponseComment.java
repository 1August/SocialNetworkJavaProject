package com.example.socialnetwork.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseComment {
    Integer postId;
    String content;
    String email;
}

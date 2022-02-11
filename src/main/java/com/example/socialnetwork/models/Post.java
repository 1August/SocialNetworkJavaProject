package com.example.socialnetwork.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    private String title;
    private String content;
    private Date createdDate;
    @OneToMany
    @JoinColumn(name = "comment_id")
    private List<Comment> comments;
    private String visibleFor;
    private boolean commentsAvailable;
}
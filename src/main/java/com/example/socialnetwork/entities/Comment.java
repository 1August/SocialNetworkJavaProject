package com.example.socialnetwork.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private User author;
    @ManyToOne
    private Post post;
    private String content;
    private Date createdDate;

    public Comment(User author, Post post, String content, Date createdDate){
        this.author = author;
        this.post = post;
        this.content = content;
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", authorId=" + author +
                ", content='" + content + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}

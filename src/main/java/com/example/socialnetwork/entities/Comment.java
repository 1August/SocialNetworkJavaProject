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
    private Integer authorId;
    private String content;
    private Date createdDate;

    public Comment(Integer author, String content, Date createdDate){
        this.authorId = author;
        this.content = content;
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", authorId=" + authorId +
                ", content='" + content + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}

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
    @JoinColumn(name = "author_id")
    private User author;
    private String content;
    private Date createdDate;

    public Comment(User author, String content, Date createdDate){
        this.author = author;
        this.content = content;
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", authorId=" + author.getId() +
                ", content='" + content + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}

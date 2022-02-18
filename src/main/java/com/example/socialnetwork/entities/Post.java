package com.example.socialnetwork.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User authorId;
    private String title;
    private String content;
    private Date createdDate;
    @OneToMany
    @JoinColumn(name = "comment_id")
    private List<Comment> comments;
    private String visibleFor;
    private boolean commentsAvailable;

    public Post(User authorId, String title, String content, Date createdDate){
        this.authorId = authorId;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.comments = new ArrayList<>();
        this.visibleFor = "111";
        this.commentsAvailable = true;

    }

    public Post addCommentToPost(Comment comment){
        comments.add(comment);
        return this;
    }


    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", authorId=" + authorId.getId() +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdDate=" + createdDate +
                ", comments=" + comments +
                ", visibleFor='" + visibleFor + '\'' +
                ", commentsAvailable=" + commentsAvailable +
                '}';
    }
}
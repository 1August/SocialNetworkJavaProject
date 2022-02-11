package com.example.socialnetwork.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    @ManyToMany
    private List<Post> posts;
    @ManyToMany
    private List<User> friends;
    @ManyToMany
    private List<User> requestedFriends;
    @ManyToMany
    private List<User> incomeFriends;
}
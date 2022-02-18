package com.example.socialnetwork.entities;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    @ManyToMany
    private List<Post> posts;
    @OneToMany
    private List<User> friends;
    @ManyToMany
    private List<User> requestedFriends;
    @ManyToMany
    private List<User> incomeFriends;

    public void addFriend(User friend) {
        this.friends.add(friend);
        friend.getFriends().add(this);
    }
}
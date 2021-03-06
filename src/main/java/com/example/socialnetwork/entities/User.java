package com.example.socialnetwork.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
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
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id")
    private List<Post> posts;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<User> friends;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<User> requestedFriends;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<User> incomeFriends;

    public User(String first_name, String last_name, String email, String password){
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.posts = new ArrayList<>();
        this.friends = new ArrayList<>();
        this.requestedFriends = new ArrayList<>();
        this.incomeFriends = new ArrayList<>();
    }

    public void addFriend(User friend) {
        this.friends.add(friend);
        friend.getFriends().add(this);
    }

    @Override
    public String toString() {
        List<Post> postsArr = new ArrayList<>(posts);

        return "User{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", posts=" + postsArr +
                ", friends=" + friends +
                ", requestedFriends=" + requestedFriends +
                ", incomeFriends=" + incomeFriends +
                '}';
    }
}
package com.example.socialnetwork.services;
import com.example.socialnetwork.models.Post;
import java.util.List;


public interface IPostService {
    public List<Post> findAllPosts() ;
    public List <Post> findPostById();

}

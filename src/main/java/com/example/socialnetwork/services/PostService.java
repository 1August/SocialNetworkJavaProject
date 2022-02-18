package com.example.socialnetwork.services;

import com.example.socialnetwork.entities.Post;
import com.example.socialnetwork.entities.User;
import com.example.socialnetwork.models.ResponsePost;
import com.example.socialnetwork.repository.PostRepository;
import com.example.socialnetwork.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    public Post savePost(Post post) {
        postRepository.save(post);
        return post;
    }

    public Post getPostById(Integer id) {
        return postRepository.getPostById(id);
    }
    public List<Post> getPostsOfUser(Integer userId){
        User user = userService.getUserById(userId);
        return user.getPosts();
    }

    public Post getPostByTitle(String title) {
        return postRepository.getPostByTitle(title);
    }

    public Post getPostByAuthor(String email) {
        return postRepository.getPostByAuthor(email);
    }



   /* public boolean addCommentToThePost(Integer commentId, Integer postID){

    }*/

    /*public Post getPostByEmail(String email){
        return  postRepository.getPostByEmail(email);
    }*/


//
//    public Post getPostById(Integer userId){
//        return
//                postRepository.getPostById(userId);
//    }
//
//    public Post getPostByEmail(Integer userId){
//        return
//                postRepository.getPostBy(userId);
//    }


/*
    public Post deletePost(Integer id) {
        Optional <Post> retrievedPost = postRepository.findPostById(id);
        if (retrievedPost == null) {
            try {
                throw new Exception("Post not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
            postRepository.deleteById(id);
            return retrievedPost.get();
        }
    }*/
}

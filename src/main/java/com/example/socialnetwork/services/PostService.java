package com.example.socialnetwork.services;

import com.example.socialnetwork.entities.Comment;
import com.example.socialnetwork.entities.Post;
import com.example.socialnetwork.entities.User;
import com.example.socialnetwork.models.ResponsePost;
import com.example.socialnetwork.repository.CommentRepository;
import com.example.socialnetwork.repository.PostRepository;
import com.example.socialnetwork.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public Post getPostById(Integer id) {
        return postRepository.getPostById(id);
    }
    public List<Post> getPostsOfUser(Integer userId){
        return postRepository.getAllByAuthorId(userId);
    }

    public Post getPostByTitle(String title) {
        return postRepository.getPostByTitle(title);
    }

    public Post getPostByAuthorId(Integer userId) {
        return postRepository.getPostByAuthorId(userId);
    }


    public Comment saveCommentInPost(Comment comment) throws Exception {
        Post post = postRepository.getPostById(comment.getPost().getId());

        post.getComments().add(commentRepository.save(comment));
        postRepository.save(post);
        return commentRepository.getCommentByPostIdAndAndContent(post.getId(), comment.getContent());
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

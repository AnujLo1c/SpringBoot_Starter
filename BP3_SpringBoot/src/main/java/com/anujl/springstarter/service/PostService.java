package com.anujl.springstarter.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anujl.springstarter.models.Post;
import com.anujl.springstarter.repository.PostRepository;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;
    public Optional<Post> findById(Long id) {
        
        return postRepository.findById(id); 
    }
    public List<Post> getAllPosts() {
       
        return postRepository.findAll(); 
    }
       public Post savePost(Post post) {
            if(post.getId() == null) {
            post.setCreatedAt(LocalDateTime.now());
            } else {
                Post existingPost = postRepository.getReferenceById(post.getId());
                post.setCreatedAt(existingPost.getCreatedAt());
            }
            return postRepository.save(post); 
        }
       public void deletePost(Long id) {
            
            postRepository.deleteById(id);
}
       public void update_post(Post post) {
        postRepository.save(post);
       }
}
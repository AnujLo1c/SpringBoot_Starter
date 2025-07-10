package com.anujl.springstarter.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.anujl.springstarter.models.Account;
import com.anujl.springstarter.models.Post;
import com.anujl.springstarter.service.AccountService;
import com.anujl.springstarter.service.PostService;

@Component
public class PreSet implements CommandLineRunner {
    @Autowired
    PostService postService;

    @Autowired
    AccountService accountService;
    
    @Override
    public void run(String... args) throws Exception {
        List<Post> posts = postService.getAllPosts();
        System.out.println("here are the posts in PreSet:");
     System.out.println(posts);
        if(posts.size()==0){
            Account account = new Account();
            account.setUsername("admin");
            account.setPassword("admin123"); 
            account.setEmail("asdfas@gmail.com");
 accountService.saveAccount(account);
               Account account1 = new Account();
            account1.setUsername("user1");
            account1.setPassword("user123");
            account1.setEmail("afwea@gmail.com");
 accountService.saveAccount(account1);            
            // System.out.println("PreSet: Initializing posts if not present.");
            Post post1 = new Post();
            post1.setTitle("First Post");
            post1.setContent("This is the content of the first post.");
            post1.setAccount(account);
            postService.savePost(post1);
            
            
            Post post2 = new Post();
            post2.setTitle("Second Post");
            post2.setContent("This is the content of the second post.");
            post2.setAccount(account1);
            postService.savePost(post2);
            
            Post post3 = new Post();
            post3.setTitle("Third Post");
            post3.setContent("This is the content of the third post.");
            post3.setAccount(account);
            postService.savePost(post3);
        }
    }
    
}

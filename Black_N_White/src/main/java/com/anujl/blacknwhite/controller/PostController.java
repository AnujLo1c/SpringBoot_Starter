package com.anujl.blacknwhite.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.anujl.blacknwhite.models.Account;
import com.anujl.blacknwhite.models.Post;
import com.anujl.blacknwhite.service.AccountService;
import com.anujl.blacknwhite.service.PostService;



@Controller
public class PostController {
    @Autowired
  private PostService postService;
  @Autowired
    private AccountService accountService;

  @GetMapping("/post/{id}")
    public String getPostById(@PathVariable("id") Long id, Model model,Principal principal) {
    Optional<Post> postOptional = postService.findById(id);
    if(postOptional.isPresent()){
            Post post = postOptional.get();
            String username=post.getAccount().getEmail();
                        if ( username != null && username.equals(principal.getName())) {
                model.addAttribute("isAuthor", true);
              }
              
              model.addAttribute("post", post);
            } else {
          model.addAttribute("isAuthor", false);
    }
        return "post"; 
    }
    @GetMapping("/post/add_post")
    public String addPost(Model model) {
      model.addAttribute("post", new Post());
        return "add_post";
    }
    @PostMapping("/post/add_submit")
    public String submitPost(@ModelAttribute Post post, Principal principal) {
      
        post.setTitle(post.getTitle());
        post.setContent(post.getContent());
        post.setCreatedAt(java.time.LocalDateTime.now());
        
       
        Account account = accountService.getCurrentAccount(principal.getName());

        post.setAccount(account);
        
        postService.savePost(post);
        
        return "redirect:/home"; 
    }
     @GetMapping("/post/{id}/edit_post")
    public String editPost(Model model,@PathVariable("id") long id,Principal principal){
      System.out.println("id from path variable: ");
      System.out.println(id);
      // System.out.println(id2);
      Optional<Post> postOptional = postService.findById(id);
    if(postOptional.isPresent()){
            Post post = postOptional.get();
            System.out.println(post);
              model.addAttribute("post", post);
             
            } 
            else{
              model.addAttribute("post",new Post());
              
              System.out.println("error");
              return "404";
            }
      
        return "edit_post";
    }
    @PostMapping("/post/{id}/edit_post")
    public String updatePost(@ModelAttribute("post") Post post, @PathVariable("id") long id){
      Optional<Post> postOptional = postService.findById(id);
       if(postOptional.isPresent()){
            Post expost = postOptional.get();

            //TODO: handle access logic
            System.out.println(expost);
             expost.setTitle(post.getTitle());
             expost.setContent(post.getContent());
             postService.update_post(expost);
            } 
            else{
              return "404";
            }
        return "redirect:/home"; 
    }
    @PostMapping("/post/{id}/delete")
    @PreAuthorize("isAuthenticated()")
public String deletePost(@PathVariable("id") long id) {
      
        try {
          postService.deletePost(id);
        } catch (Exception e) {
          // TODO: handle exception
          return "404";
        }
        return "redirect:/home"; 
    }
  }

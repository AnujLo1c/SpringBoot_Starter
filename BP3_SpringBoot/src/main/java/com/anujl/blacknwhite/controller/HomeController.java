package com.anujl.blacknwhite.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.anujl.blacknwhite.models.Post;
import com.anujl.blacknwhite.service.PostService;




@Controller
public class HomeController {

    @Autowired
    PostService postService;
    


    @GetMapping("/home")
    public String home(Model model) {
List<Post> post = postService.getAllPosts();
        model.addAttribute("posts", post);
        return new String("home");
    }
   
    

   
    
}

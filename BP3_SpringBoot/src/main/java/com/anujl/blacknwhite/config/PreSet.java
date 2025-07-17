package com.anujl.blacknwhite.config;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.anujl.blacknwhite.models.Account;
import com.anujl.blacknwhite.models.Authority;
import com.anujl.blacknwhite.models.Post;
import com.anujl.blacknwhite.service.AccountService;
import com.anujl.blacknwhite.service.AuthorityService;
import com.anujl.blacknwhite.service.PostService;
import com.anujl.blacknwhite.util.constants.Privilages;
import com.anujl.blacknwhite.util.constants.Roles;

@Component
public class PreSet implements CommandLineRunner {
    @Autowired
    PostService postService;

    @Autowired
    AccountService accountService;
    @Autowired
    AuthorityService authorityService;
    
    @Override
    public void run(String... args) throws Exception {

for(Privilages auth:Privilages.values()){
            Authority authority = new Authority();
            // authority.setId(auth.getId());
            authority.setPrivilage(auth.getPrivilage());
            authorityService.saveAuthority(authority);
        }
  



     Account account = new Account();
            account.setFirstName("Na...");
            account.setLastName("Dhote");
            account.setPassword("na03"); 
            account.setEmail("anujlowanshi3@gmail.com");
            account.setRole(Roles.USER.getRole());
            account.setAddress("123 Main St, City, Country");
            account.setPhoneNumber("1234567890");
 accountService.saveAccount(account);
    Account account2 = new Account();
            account2.setFirstName("admin");
            account2.setLastName("Dhote");
            account2.setPassword("admin123"); 
            account2.setEmail("asdfas@gmail.com");
            account2.setAddress("123 Main St, City, Country");
            account2.setPhoneNumber("1234567890");
            account2.setRole(Roles.EDITOR.getRole());
 accountService.saveAccount(account2);

               Account account1 = new Account();
            account1.setFirstName("user1");
            account1.setLastName("lownashidfe");

            account1.setPassword("user123");
            account1.setEmail("afwea@gmail.com");
             account1.setRole(Roles.ADMIN.getRole());
            account1.setAddress("123 Main St, City, Country");
            account1.setPhoneNumber("1234567890");
             Set<Authority> authorities = new HashSet<Authority>();
             authorityService.findById(Privilages.ACCESS_ADMIN_DASHBOARD.getId()).ifPresent(authorities:: add);
            authorityService.findById(Privilages.RESET_ANY_USER_PASSWORD.getId()).ifPresent(authorities::add);
            account1.setPrivilages(authorities);
             accountService.saveAccount(account1);      

        List<Post> posts = postService.getAllPosts();
        System.out.println("here are the posts in PreSet:");
     System.out.println(posts);
        if(posts.size()==0){
             
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
            post3.setAccount(account2);
            postService.savePost(post3);
        }
    }
    
}

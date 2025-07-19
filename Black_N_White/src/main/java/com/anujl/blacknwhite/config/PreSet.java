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
import com.anujl.blacknwhite.util.constants.CategoryType;
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
post1.setCategory(CategoryType.LIFESTYLE);
            
            postService.savePost(post1);
            
            
            Post post2 = new Post();
            post2.setTitle("Second Post asdf aefe waefawfedafsfafeaa ga g       weasgewgasfgsfsefewa");
            post2.setContent("This is the content of the second post. Marble Collector\r\n" + //
                                "There are a total of \r\n" + //
                                "M\r\n" + //
                                "M possible types of marbles that you want to collect. They are numbered \r\n" + //
                                "1\r\n" + //
                                ",\r\n" + //
                                "2\r\n" + //
                                ",\r\n" + //
                                "…\r\n" + //
                                ",\r\n" + //
                                "M\r\n" + //
                                "1,2,…,M.\r\n" + //
                                "\r\n" + //
                                "You currently have \r\n" + //
                                "N\r\n" + //
                                "N marbles with you, with types \r\n" + //
                                "A\r\n" + //
                                "1\r\n" + //
                                ",\r\n" + //
                                "A\r\n" + //
                                "2\r\n" + //
                                ",\r\n" + //
                                "…\r\n" + //
                                ",\r\n" + //
                                "A\r\n" + //
                                "N\r\n" + //
                                "A \r\n" + //
                                "1\r\n" + //
                                "​\r\n" + //
                                " ,A \r\n" + //
                                "2\r\n" + //
                                "​\r\n" + //
                                " ,…,A \r\n" + //
                                "N\r\n" + //
                                "​\r\n" + //
                                " . Note that you may have the same type of marble twice or more.\r\n" + //
                                "\r\n" + //
                                "Find number of types of marbles that you still have not collected.\r\n" + //
                                "\r\n" + //
                                "Input Format\r\n" + //
                                "The first line of input will contain a single integer \r\n" + //
                                "T\r\n" + //
                                "T, denoting the number of test cases.\r\n" + //
                                "Each test case consists of multiple lines of input.\r\n" + //
                                "The first line of each test case contains \r\n" + //
                                "N\r\n" + //
                                "N and \r\n" + //
                                "M\r\n" + //
                                "M - the number of marbles you have, and the total possible types of marbles.\r\n" + //
                                "The second line contains \r\n" + //
                                "N\r\n" + //
                                "N integers - \r\n" + //
                                "A\r\n" + //
                                "1\r\n" + //
                                ",\r\n" + //
                                "A\r\n" + //
                                "2\r\n" + //
                                ",\r\n" + //
                                "…\r\n" + //
                                ",\r\n" + //
                                "A\r\n" + //
                                "N\r\n" + //
                                "A \r\n" + //
                                "1\r\n" + //
                                "​\r\n" + //
                                " ,A \r\n" + //
                                "2\r\n" + //
                                "​\r\n" + //
                                " ,…,A \r\n" + //
                                "N\r\n" + //
                                "​\r\n" + //
                                " .");
            post2.setAccount(account1);
            post2.setCategory(CategoryType.LIFESTYLE);
            postService.savePost(post2);
            
            Post post3 = new Post();
            post3.setTitle("Third Post");
            post3.setContent("This is the content of the third post.");
            post3.setAccount(account2);
            post3.setCategory(CategoryType.TECHNOLOGY);
            postService.savePost(post3);
        }
    }
    
}

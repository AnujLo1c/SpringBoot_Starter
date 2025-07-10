package com.anujl.springstarter.controller;
import com.anujl.springstarter.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

// import com.anujl.springstarter.config.AccountService;
import com.anujl.springstarter.models.Account;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class AccountController {

    private final AccountService accountService;

    AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    
     @GetMapping("/register")
    public String register(Model model) {
        Account account=new Account();
        model.addAttribute("account", account);
        return "register";
    }
    @PostMapping("/register")
    public String postMethodName(@ModelAttribute Account account) {
        //TODO: process POST request
        accountService.saveAccount(account);
        return "redirect:/home";
    }
    
    
}

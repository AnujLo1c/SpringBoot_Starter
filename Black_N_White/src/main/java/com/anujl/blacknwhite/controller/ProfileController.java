package com.anujl.blacknwhite.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.anujl.blacknwhite.models.Account;
import com.anujl.blacknwhite.service.AccountService;


@Controller
public class ProfileController {
    @Autowired
    private  AccountService accountService;

   
    @GetMapping("/profile")
    public String profile(Model model,Principal principal) {

        Account account = accountService.getCurrentAccount(principal.getName());
        if (account == null) {
            return "redirect:/login";
        }
        model.addAttribute("account", account);
        return new String("profile");
    }
    @PostMapping("/profile/edit_profile")
    public String editProfile(Model model, Principal principal) {
        Account account = accountService.getCurrentAccount(principal.getName());
        if (account == null) {
            return "redirect:/login";
        }
        model.addAttribute("account", account);
        return new String("update_profile");
    }
    @PostMapping("/profile/update_profile")
    public String updateProfile(Account account, Principal principal) {
        Account existingAccount = accountService.getCurrentAccount(principal.getName());
        if (existingAccount == null) {
            return "redirect:/login";
        }
        existingAccount.setFirstName(account.getFirstName());
        existingAccount.setLastName(account.getLastName());
        existingAccount.setEmail(account.getEmail());

        existingAccount.setGender(account.getGender());
        existingAccount.setDateOfBirth(account.getDateOfBirth());
        // Update other fields as necessary
        accountService.saveAccount(existingAccount);
        return "redirect:/profile";
    }
    
}

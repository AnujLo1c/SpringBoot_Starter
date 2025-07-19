package com.anujl.blacknwhite.controller;

import jakarta.validation.Valid;

import java.time.LocalTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.anujl.blacknwhite.dto.EmailDetails;
import com.anujl.blacknwhite.models.Account;
import com.anujl.blacknwhite.service.AccountService;
import com.anujl.blacknwhite.service.EmailServiceImpl;
import com.anujl.blacknwhite.util.constants.Roles;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private EmailServiceImpl emailServiceImpl;

    @GetMapping("/register")
    public String register(Model model) {
        if (!model.containsAttribute("account")) {
            model.addAttribute("account", new Account());
        }
        return "register"; 

    } 

    @PostMapping("/register")
    public String formSubmission(@Valid @ModelAttribute("account") Account account,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
System.out.println("pirng");
if (bindingResult.hasErrors()) {
            System.out.println("pirngasfwe");
            System.out.println(bindingResult.toString());
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.account", bindingResult);
            redirectAttributes.addFlashAttribute("account", account);
            return "redirect:/register";
        }

        account.setRole(Roles.USER.getRole());
        accountService.saveAccount(account);
        redirectAttributes.addFlashAttribute("success", "Registration successful. Please login.");
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model) {

        return new String("login");
    }

    @GetMapping("/forgot-password")
    public String forgotPassword(Model model) {
        return new String("forgot");
    }

    @GetMapping("/new-password")
    public String newPassword(@RequestParam("param") String token, Model model) {

        model.addAttribute("token", token);
        return new String("new_pass");
    }

    @GetMapping("/forget_pass")
    public String forgetpassword() {
        System.out.println("Forget Password GET method called");
        return new String("forget");
    }

    @PostMapping("/forgot-password")
    public String forgotPasswordSubmit(@RequestParam("email") String email, RedirectAttributes redirectAttributes) {
        System.out.println("Forget Password POST method called with email: " + email);
        Account account = accountService.getCurrentAccount(email);

        if (account != null) {

            String token = UUID.randomUUID().toString();
            account.setToken(token);
            account.setTokenExpiryTime(LocalTime.now().plusMinutes(10));
            accountService.saveAccount(account);

            EmailDetails emailDetails = new EmailDetails();
            emailDetails.setRecipient(email);
            emailDetails.setSubject("Password Reset Request");
            emailDetails.setMsgBody("Please click the link below to reset your password:\n"
                    + "http://localhost:8080/new-password?param=" + token);

            emailServiceImpl.sendSimpleMail(emailDetails);
            redirectAttributes.addFlashAttribute("success", "Password reset link sent to your email.");
            return "redirect:/login";
        } else {
            redirectAttributes.addFlashAttribute("error", "Failed to send password reset link. Please try again.");
            return "forget";
        }

    }

    @PostMapping("/new-password")
    public String confirmPassword(@RequestParam("param") String token, Model model,
            @RequestParam("password") String password, @RequestParam("confirmPassword") String confirmPassword,
          RedirectAttributes redirectAttributes) {
              System.out.println(password+" "+confirmPassword);
              System.out.println("Token received: " + token);
        if (!password.equals(confirmPassword)) {

            redirectAttributes.addFlashAttribute("error", "Passwords do not match. Please try again.");
            return "redirect:/new-password";

        }
        Account account = accountService.getCurrentAccountByToken(token);
 
//  System.out.println(account);
 
 if (account != null && account.getTokenExpiryTime().isAfter(LocalTime.now())) {
PasswordEncoder passwordEncoder =new BCryptPasswordEncoder();
            
account.setPassword(passwordEncoder.encode(password));
            account.setToken(null); 
            account.setTokenExpiryTime(null); 
            // System.out.println("Password before encoding: " + account.getPassword());
accountService.saveAccount(account);
            model.addAttribute("success", "Password changed successfully.");
            return "login";
        } else {
            model.addAttribute("error", "Invalid or expired token.");
            return "forget";
        }
    }
}

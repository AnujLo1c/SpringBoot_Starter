package com.anujl.blacknwhite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class AdminController {
    @GetMapping("/admin")
    public String adminPage(Model model) {
        return "admin"; 
    }
    @GetMapping("/editor")
    public String editor(Model model) {
        return "editor"; 
    }
}

package com.anujl.springstarter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import ch.qos.logback.core.model.Model;


@Controller
public class ProfileController {
    @GetMapping("/profile")
    public String profile(Model model) {
        return new String("profile");
    }
    
}

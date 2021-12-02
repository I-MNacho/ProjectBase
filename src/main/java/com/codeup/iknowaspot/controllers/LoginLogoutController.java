package com.codeup.iknowaspot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginLogoutController  {

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/logout")
    public String showLogoutForm(Model model, String logout) {

        if (logout != null)
        model.addAttribute("message", "You have been logged out successfully.");

        return "/home";
    }
}


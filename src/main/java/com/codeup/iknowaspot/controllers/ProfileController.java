package com.codeup.iknowaspot.controllers;

import com.codeup.iknowaspot.models.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ProfileController {
 @GetMapping("/profile")
    public String profilePage(Model model){

     User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    model.addAttribute("user", user);
     return "/profile";
 }

}

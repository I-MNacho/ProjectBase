package com.codeup.iknowaspot.controllers;
import com.codeup.iknowaspot.models.Event;
import com.codeup.iknowaspot.models.User;
import com.codeup.iknowaspot.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EditProfile {
private UserRepository userRepository;

    public EditProfile(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/profile/edit")
    public String showEditPage(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userInDB = userRepository.findByUsername(user.getUsername());
        model.addAttribute("user", userInDB);
        return "edit-profile";

    }

    // update profile
    @PostMapping("/profile/edit")
    public String editEvent(@ModelAttribute User user){
//        userDao.save(user);
        return "redirect:/profile/edit";
    }
}

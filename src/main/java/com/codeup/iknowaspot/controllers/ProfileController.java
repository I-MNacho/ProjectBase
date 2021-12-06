package com.codeup.iknowaspot.controllers;

import com.codeup.iknowaspot.models.Event;
import com.codeup.iknowaspot.models.User;
import com.codeup.iknowaspot.repositories.EventRepository;
import com.codeup.iknowaspot.repositories.SpotRepository;
import com.codeup.iknowaspot.repositories.UserRepository;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class ProfileController {
    private EventRepository eventRepository;
    private UserRepository userRepository;
    private SpotRepository spotRepository;

    public ProfileController(UserRepository userRepository, EventRepository eventRepository, SpotRepository spotRepository) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.spotRepository = spotRepository;
    }


    @GetMapping("/profile")
    public String profilePage(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userInDb = userRepository.getById(user.getId());
        List<Event> usersEvents = eventRepository.findAllByUser(userInDb);
        model.addAttribute("events", usersEvents);
        model.addAttribute("spots", userInDb.getSpots());
        model.addAttribute("user", userInDb);
        return "/profile";
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
    public String editProfile(@ModelAttribute User user){
        userRepository.save(user);
        return "profile";
    }

    @PostMapping(path = "/profile/upload", consumes = MediaType.TEXT_PLAIN_VALUE)
    public String uploadProfilePhoto(@RequestBody String url) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userInDB = userRepository.findByUsername(user.getUsername());
        user.setProfilePhotoURL(url);
        userRepository.save(user);
        return "profile";
    }

//@GetMapping("/profile/myEvents")
//    public String userEvents(Model model){
//     Event event = (Event)
//}
}

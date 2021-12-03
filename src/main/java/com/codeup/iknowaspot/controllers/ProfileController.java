package com.codeup.iknowaspot.controllers;

import com.codeup.iknowaspot.models.Event;
import com.codeup.iknowaspot.models.User;
import com.codeup.iknowaspot.repositories.EventRepository;
import com.codeup.iknowaspot.repositories.SpotRepository;
import com.codeup.iknowaspot.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
//        model.addAttribute("spots", userInDb.getSpots());
        model.addAttribute("user", userInDb);
        return "/profile";
    }

//@GetMapping("/profile/myEvents")
//    public String userEvents(Model model){
//     Event event = (Event)
//}
}

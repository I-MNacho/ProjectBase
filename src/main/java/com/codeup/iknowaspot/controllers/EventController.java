package com.codeup.iknowaspot.controllers;

import com.codeup.iknowaspot.models.Event;
import com.codeup.iknowaspot.models.Spot;
import com.codeup.iknowaspot.models.User;
import com.codeup.iknowaspot.repositories.EventRepository;
import com.codeup.iknowaspot.repositories.SpotRepository;
import com.codeup.iknowaspot.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class EventController {

    //Dao's
    private EventRepository eventsDao;
    private UserRepository usersDao;
    private SpotRepository spotsDao;

    //constructors
    public EventController() {
    }

    public EventController(EventRepository eventsDao, UserRepository usersDao, SpotRepository spotsDao) {
        this.eventsDao = eventsDao;
        this.usersDao = usersDao;
        this.spotsDao = spotsDao;
    }

    //getters and setters
    public EventRepository getEventsDao() {
        return eventsDao;
    }

    public void setEventsDao(EventRepository eventsDao) {
        this.eventsDao = eventsDao;
    }

    public UserRepository getUsersDao() {
        return usersDao;
    }

    public void setUsersDao(UserRepository usersDao) {
        this.usersDao = usersDao;
    }

    public SpotRepository getSpotsDao() {
        return spotsDao;
    }

    public void setSpotsDao(SpotRepository spotsDao) {
        this.spotsDao = spotsDao;
    }

    //create event
    @GetMapping("/event/create")
    public String createEvent(Model model) {
        model.addAttribute("event", new Event());
        return "event/create";
    }


    //delete event
    @PostMapping("/home_page_goes_here/{id}/delete")
    public String deleteEvent(@PathVariable long id) {
        eventsDao.deleteById(id);
        return "redirect:/back_to_homepage";
    }

    //inserting event
    @PostMapping("/event/create")
    public String insertEvent(@ModelAttribute Event event) {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User author = usersDao.getById(principal.getId());
//        spot.setUser(author);
        eventsDao.save(event);
        return "redirect:/spots";
    }




}

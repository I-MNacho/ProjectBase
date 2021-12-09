package com.codeup.iknowaspot.controllers;

import com.codeup.iknowaspot.models.Event;
import com.codeup.iknowaspot.models.Spot;
import com.codeup.iknowaspot.models.User;
import com.codeup.iknowaspot.repositories.EventRepository;
import com.codeup.iknowaspot.repositories.SpotRepository;
import com.codeup.iknowaspot.repositories.UserRepository;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;
import java.util.logging.Logger;

@Controller
public class EventController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(EventController.class.getName());
    //Dao's
    private EventRepository eventsDao;
    private UserRepository usersDao;
    private SpotRepository spotsDao;


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
    @GetMapping("/events")
    public String listEvent(Model model) {
        //sb wires uses eventsDao to list all events in the database & assign it to the events atrb.
        // TODO: filter only events that end after today
        model.addAttribute("events", eventsDao.findAll());

        //page shows to this bc its mapped here:  //
        return "events/index";
    }

    //create event
    @GetMapping("/events/create/{spot_id}")
    public String createEvent(Model model, @PathVariable Long spot_id) {
        //creating a new event obj and assg atrb = assn obj atb
        Event event = new Event();
        event.setSpot(spotsDao.getById(spot_id));
        model.addAttribute("event", event);
        model.addAttribute("latitude", event.getSpot().getLatitude());
        model.addAttribute("longitude", event.getSpot().getLongitude());

        //page shows to this bc its mapped here:  //
        return "events/create";
    }


    //inserting event
    // postmapping request will insert the event into the DB
    @PostMapping("/events/create")
    public String insertEvent(@ModelAttribute Event event) {
//        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User author = usersDao.getById(principal.getId());
        User author = usersDao.getById(1L);
        event.setUser(author);
        eventsDao.save(event);
        return "redirect:/events";
    }

    // edit event
    @GetMapping("/events/edit/{id}")
    public String editEvent(@PathVariable long id, Model model){
        //creating the event & setting the id & setting atrb
        model.addAttribute("event", eventsDao.findById(id));
//      just updating i.e ^^^^^
        return "events/edit";
    }


    // update event
    @PostMapping("/events/edit")
    public String editEvent(@ModelAttribute Event event){
      eventsDao.save(event);
//      just updating i.e ^^^^^
      return "redirect:/events";
    }


    //delete event

    @GetMapping("/events/delete/{id}")
    public String deleteEvent(@PathVariable long id) {
        eventsDao.deleteById(id);
        return "redirect:/events";
    }


}

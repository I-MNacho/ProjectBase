package com.codeup.iknowaspot.controllers;

import com.codeup.iknowaspot.models.Spot;
import com.codeup.iknowaspot.repositories.EventRepository;
import com.codeup.iknowaspot.repositories.JoinedEventsRepository;
import com.codeup.iknowaspot.repositories.SpotRepository;
import com.codeup.iknowaspot.repositories.UserRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class JoinedEventsController {
    //Dao's
    private JoinedEventsRepository joinedEventsDao;
    private EventRepository eventsDao;
    private SpotRepository spotsDao;
    private UserRepository usersDao;

    //constructor
    public JoinedEventsController(JoinedEventsRepository joinedEventsDao, EventRepository eventsDao, SpotRepository spotDao, UserRepository userDao) {
        this.spotsDao = spotDao;
        this.usersDao = userDao;
    }

    //empty constructor
    public JoinedEventsController() {
    }

    //getters and setters
    public JoinedEventsRepository getJoinedEventsDao() {
        return joinedEventsDao;
    }

    public void setJoinedEventsDao(JoinedEventsRepository joinedEventsDao) {
        this.joinedEventsDao = joinedEventsDao;
    }

}

package com.codeup.iknowaspot.controllers;

import com.codeup.iknowaspot.models.Event;
import com.codeup.iknowaspot.models.Tag;
import com.codeup.iknowaspot.models.User;
import com.codeup.iknowaspot.repositories.EventRepository;
import com.codeup.iknowaspot.repositories.SpotRepository;
import com.codeup.iknowaspot.repositories.TagRepository;
import com.codeup.iknowaspot.repositories.UserRepository;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class TagController {

    //Dao's
    private EventRepository eventsDao;
    private UserRepository usersDao;
    private SpotRepository spotsDao;
    private TagRepository tagsDao;

    //constructors
    public TagController() {
    }

    public TagController(EventRepository eventsDao, UserRepository usersDao, SpotRepository spotsDao, TagRepository tagsDao) {
        this.eventsDao = eventsDao;
        this.usersDao = usersDao;
        this.spotsDao = spotsDao;
        this.tagsDao = tagsDao;
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

    public TagRepository getTagsDao() {
        return tagsDao;
    }

    public void setTagsDao(TagRepository tagsDao) {
        this.tagsDao = tagsDao;
    }

    //create tag
    @GetMapping("/tag/create")
    public String createTag(Model model) {
        model.addAttribute("tag", new Tag());
        return "tag/create";
    }


    //delete tag
    @PostMapping("/home_page_goes_here/{id}/delete")
    public String deleteTag(@PathVariable long id) {
        tagsDao.deleteById(id);
        return "redirect:/back_to_homepage";
    }

    //inserting tag
    @PostMapping("/tag/create")
    public String insertTag(@ModelAttribute Tag tag) {
//        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User author = usersDao.getById(principal.getId());
//        spot.setUser(author);
        tagsDao.save(tag);
        return "redirect:/spots";
    }









}

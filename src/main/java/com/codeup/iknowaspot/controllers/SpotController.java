package com.codeup.iknowaspot.controllers;

import com.codeup.iknowaspot.models.Spot;
import com.codeup.iknowaspot.models.User;
import com.codeup.iknowaspot.repositories.SpotRepository;
import com.codeup.iknowaspot.repositories.UserRepository;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class SpotController {

    //Dao's
    private SpotRepository spotsDao;
    private UserRepository usersDao;

    //constructor
    public SpotController(SpotRepository spotDao, UserRepository userDao) {
        this.spotsDao = spotDao;
        this.usersDao = userDao;
    }

    //empty constructor
    public SpotController() {
    }

    //getters and setters
    public SpotRepository getSpotDao() {
        return spotsDao;
    }

    public void setSpotDao(SpotRepository spotDao) {
        this.spotsDao = spotDao;
    }

    //create spot
    @GetMapping("/spot/create")
    public String createSpot(Model model) {
        model.addAttribute("spot", new Spot());
        return "spot/create";
    }


    //inserting spot
    @PostMapping("/spot/create")
    public String insert(@ModelAttribute Spot spot) {
//        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User author = usersDao.getById(principal.getId());
//        spot.setUser(author);
        spotsDao.save(spot);
        return "redirect:/spots";
    }


    //delete Spot
    @PostMapping("/home_page_goes_here/{id}/delete")
    public String deleteSpot(@PathVariable long id) {
        spotsDao.deleteById(id);
        return "redirect:/back_to_homepage";
    }

}

package com.codeup.iknowaspot.controllers;

import com.codeup.iknowaspot.models.Spot;
import com.codeup.iknowaspot.models.User;
import com.codeup.iknowaspot.repositories.SpotRepository;
import com.codeup.iknowaspot.repositories.UserRepository;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpotController {

    private static final Logger LOGGER=LoggerFactory.getLogger(SpotController.class);
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

    //create spot mapping
    // Takes latitude and longitude as url parameters to create Spot model
    @GetMapping("/spots/create")
    public String createSpot(@RequestParam(name="lat") Double lat, @RequestParam(name="lng") Double lng, Model model) {
        Spot spot = new Spot();
        spot.setLatitude(lat);
        spot.setLongitude(lng);
        model.addAttribute("spot", spot);
        return "spots/create";
    }


    //inserting spot
    @PostMapping("/spots/create")
    public String insert(@ModelAttribute Spot spot) {
        LOGGER.warn("Title: " + spot.getTitle());
        LOGGER.warn("Description: " + spot.getDescription());
        LOGGER.warn("Longitude: " + spot.getLongitude());
        LOGGER.warn("Longitude: " + spot.getLongitude());

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

package com.codeup.iknowaspot.controllers;

import com.codeup.iknowaspot.models.Spot;
import com.codeup.iknowaspot.models.User;
import com.codeup.iknowaspot.repositories.SpotRepository;
import com.codeup.iknowaspot.repositories.UserRepository;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    //getters and setters
    public SpotRepository getSpotDao() {
        return spotsDao;
    }

    public void setSpotDao(SpotRepository spotDao) {
        this.spotsDao = spotDao;
    }

    // mapping for spots list page mapped to "spots/home.html"
    @GetMapping("/spots")
    public String index(Model model) {
        model.addAttribute("spots", spotsDao.findAll());
        return "spots/index";
    }

    @GetMapping("/spots/{id}")
    public String oneSpotView(Model model, @PathVariable long id){
        Spot spot = spotsDao.getById((long) id);
        model.addAttribute("latitude", spot.getLatitude());
        model.addAttribute("longitude", spot.getLongitude());
        model.addAttribute("spot", spot);
        return "/spots/one-spot";
    }


    //create spot mapping
    // takes latitude and longitude as url parameters to create Spot model
//    @GetMapping("/spots/create")
//    public String createSpot(@RequestParam(name="lat") Double lat, @RequestParam(name="lng") Double lng, Model model) {
//        Spot spot = new Spot();
//        spot.setLatitude(lat);
//        spot.setLongitude(lng);
//        model.addAttribute("spot", spot);
//        return "spots/create";
//    }

    @GetMapping("/spots/{id}/update")
    public String updateSpot(@PathVariable long id){
        //spot id to be updated
        spotsDao.getById(id);
//        needs all info thats on the spot


//        needs to be able to keep same id


        return "home";
    }

    @GetMapping("/spots/save/{id}")
    public String saveSpot(@PathVariable long id){
        Spot spot = spotsDao.getById(id);
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User author = usersDao.getById(principal.getId());
        author.addSpot(spot);
        usersDao.save(author);
        return "redirect:/profile";
    }

    @GetMapping("/spots/unsave/{id}")
    public String unsaveSpot(@PathVariable long id){
        Spot spot = spotsDao.getById(id);
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User author = usersDao.getById(principal.getId());
        author.removeSpot(spot);
        usersDao.save(author);
        return "redirect:/profile";
    }

    //inserting spot
    @PostMapping("/spots/create")
    public String insert(@ModelAttribute Spot spot) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        spot.setUser(usersDao.getById(user.getId()));
        spotsDao.save(spot);
        if (spot.getTitle().isEmpty()) {
            System.out.println("Title is empty.");
            return "home";
        }

        if (spot.getDescription().isEmpty()) {
            System.out.println("Description is empty.");
            return "home";
        }

        return "redirect:/spots";
    }


    //delete Spot
    @PostMapping("spot/{id}/delete")
    public String deleteSpot(@PathVariable long id) {
        spotsDao.deleteById(id);
        return "redirect:/home";
    }


}

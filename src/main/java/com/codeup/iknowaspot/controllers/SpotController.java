package com.codeup.iknowaspot.controllers;

import com.codeup.iknowaspot.models.Event;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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
        try {
            User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User author = usersDao.getById(principal.getId());
            model.addAttribute("user", author);
        } catch(Exception e) {
            model.addAttribute("user", new User());
        }
        return "spots/list";
    }

    @GetMapping("/spots/mine")
    public String getMySpots(Model model) {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User author = usersDao.getById(principal.getId());
        model.addAttribute("user", author);
        model.addAttribute("spots", spotsDao.findAllByUser(author));
        return "spots/list";
    }

    @GetMapping("/spots/favorites")
    public String getMyFavoriteSpots(Model model) {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User author = usersDao.getById(principal.getId());
        model.addAttribute("user", author);
        model.addAttribute("spots", spotsDao.findAllBySaved(author));
        return "spots/list";
    }

    @GetMapping("/spots/{id}")
    public String oneSpotView(Model model, @PathVariable long id){
        Spot spot = spotsDao.getById((long) id);
        model.addAttribute("latitude", spot.getLatitude());
        model.addAttribute("longitude", spot.getLongitude());
        model.addAttribute("spot", spot);
        return "spots/one-spot";
    }

    @GetMapping("/spots/edit/{id}")
    public String updateSpot(Model model, @PathVariable long id){
        List<Spot> spots = spotsDao.findAll();
        model.addAttribute("spots", spots);
        model.addAttribute("spot", spotsDao.getById(id));
        try {
            User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User author = usersDao.getById(principal.getId());
            model.addAttribute("user", author);
        } catch(Exception e) {
            model.addAttribute("user", new User());
        }
        return "spots/edit";
    }

    @PostMapping("/spots/edit")
    public String updateSpot(@ModelAttribute Spot spot, RedirectAttributes redirAttrs){
        redirAttrs.addFlashAttribute("success", "Successfully edited spot.");
        spotsDao.save(spot);
        return "redirect:/spots";
    }

    @GetMapping("/spots/save/{id}")
    public String saveSpot(@PathVariable long id, @RequestHeader("Referer") String referer, RedirectAttributes redirAttrs){
        redirAttrs.addFlashAttribute("success", "Successfully saved spot.");
        Spot spot = spotsDao.getById(id);
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User author = usersDao.getById(principal.getId());
        spot.favorite(author);
        spotsDao.save(spot);
        return "redirect:" + referer;
    }

    @GetMapping("/spots/unsave/{id}")
    public String unsaveSpot(@PathVariable long id, @RequestHeader("Referer") String referer, RedirectAttributes redirAttrs){
        redirAttrs.addFlashAttribute("success", "Successfully unsaved spot.");
        Spot spot = spotsDao.getById(id);
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User author = usersDao.getById(principal.getId());
        spot.unfavorite(author);
        spotsDao.save(spot);
        return "redirect:" + referer;
    }

    //inserting spot
    @PostMapping("/spots/create")
    public String insert(@ModelAttribute Spot spot, RedirectAttributes redirAttrs) {
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
        redirAttrs.addFlashAttribute("success", "Successfully created spot.");
        return "redirect:/spots";
    }

    //delete Spot
    @GetMapping("spot/{id}/delete")
    public String deleteSpotFromHome(@PathVariable long id, RedirectAttributes redirAttrs) {
        redirAttrs.addFlashAttribute("success", "Successfully deleted spot.");
        spotsDao.deleteById(id);
        return "redirect:/home";
    }
    @GetMapping("/spots/delete/{id}")
    public String deleteSpotFromList(@PathVariable long id, RedirectAttributes redirAttrs) {
        redirAttrs.addFlashAttribute("success", "Successfully deleted spot.");
        spotsDao.deleteById(id);
        return "redirect:/spots";
    }


}

package com.codeup.iknowaspot.controllers;

import com.codeup.iknowaspot.models.Spot;
import com.codeup.iknowaspot.models.User;
import com.codeup.iknowaspot.repositories.ReviewsRepository;
import com.codeup.iknowaspot.repositories.SpotRepository;
import com.codeup.iknowaspot.repositories.UserRepository;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class ReviewsController {

    private ReviewsRepository reviewsDao;
    private SpotRepository spotsDao;
    private UserRepository usersDao;

    //constructor
    public ReviewsController(SpotRepository spotDao, UserRepository userDao, ReviewsRepository reviewsDao) {
        this.spotsDao = spotDao;
        this.usersDao = userDao;
        this.reviewsDao = reviewsDao;
    }

    //empty constructor
    public ReviewsController() {
    }

    public class Review {
    }

    //getters and setters
    public ReviewsController getReviewsDao() {
        return (ReviewsController) reviewsDao;
    }

    public void setSpotDao(ReviewsRepository reviewsDao) {
        this.reviewsDao = reviewsDao;
    }

    //create review
    @GetMapping("/reviews/create")
    public String create(Model model) {
        model.addAttribute("review", new ReviewsController.Review());
        return "review/create";
    }


    //inserting review
    @PostMapping("/review/create")
    public String insert(@ModelAttribute Spot spot) {
        spotsDao.save(spot);
        return "redirect:/reviews";
    }


    //delete function
    @PostMapping("/home_page_goes_here/{id}/delete")
    public String deletePost(@PathVariable long id) {
        spotsDao.deleteById(id);
        return "redirect:/back_to_homepage";
    }


}


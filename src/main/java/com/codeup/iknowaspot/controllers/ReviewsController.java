package com.codeup.iknowaspot.controllers;
import com.codeup.iknowaspot.models.Review;

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

    public ReviewsController(ReviewsRepository reviewsDao, SpotRepository spotsDao, UserRepository usersDao) {
        this.reviewsDao = reviewsDao;
        this.spotsDao = spotsDao;
        this.usersDao = usersDao;
    }


    //create review
    @GetMapping("/review/create")
    public String createReview(Model model) {
        model.addAttribute("review", new Review());
        return "reviews/create-review";
    }


    //inserting review
    @PostMapping("/review/create")
    public String insertReview(@ModelAttribute Review review) {
        reviewsDao.save(review);
        return "redirect:/spots";
    }


    //delete function
    @PostMapping("/home_page_goes_here/{id}/delete")
    public String deleteReview(@PathVariable long id) {
        reviewsDao.deleteById(id);
        return "redirect:/back_to_homepage";
    }


}


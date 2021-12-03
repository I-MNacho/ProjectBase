package com.codeup.iknowaspot.controllers;

import com.codeup.iknowaspot.models.Spot;
import com.codeup.iknowaspot.models.User;
import com.codeup.iknowaspot.repositories.SpotRepository;
import com.codeup.iknowaspot.repositories.UserRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FavSpotController {

  //variables
  private SpotRepository spotsDao;
  private UserRepository usersDao;


  //constructors
  public FavSpotController() {
  }

  public FavSpotController(SpotRepository spotsDao, UserRepository usersDao) {
    this.spotsDao = spotsDao;
    this.usersDao = usersDao;
  }

  public SpotRepository getSpotsDao() {
    return spotsDao;
  }

  public void setSpotsDao(SpotRepository spotsDao) {
    this.spotsDao = spotsDao;
  }

  public UserRepository getUsersDao() {
    return usersDao;
  }

  public void setUsersDao(UserRepository usersDao) {
    this.usersDao = usersDao;
  }

  @GetMapping("/favorite_spot")
  public String showFavoriteSpot(){
    return "/favorite_spot"; }



  @GetMapping("/favorite_spot/save/{id}")
  public String saveFavoriteSpot(@PathVariable long id){
    Spot favoriteSpot = spotsDao.getById(id);
    User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    User author = usersDao.getById(principal.getId());
    favoriteSpot.setUser(author);
    spotsDao.save(favoriteSpot);
    return "redirect:/profile";
  }

  @PostMapping("/favorite_spot/create")
  public String insertFavoriteSpot(@ModelAttribute Spot spot) {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    spot.setUser(usersDao.getById(user.getId()));
    spotsDao.save(spot);
    return "redirect:/profile";
  }


  }
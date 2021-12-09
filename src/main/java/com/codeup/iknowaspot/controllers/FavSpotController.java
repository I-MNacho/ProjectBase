package com.codeup.iknowaspot.controllers;

import com.codeup.iknowaspot.models.Spot;
import com.codeup.iknowaspot.models.User;
import com.codeup.iknowaspot.repositories.SpotRepository;
import com.codeup.iknowaspot.repositories.UserRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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


  @PostMapping("/favorite_spot/save/{id}")
  public String successMessage(@PathVariable long id, RedirectAttributes redirectAttributes){
    Spot favoriteSpot = spotsDao.getById(id);
    User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    User author = usersDao.getById(principal.getId());
    favoriteSpot.setUser(author);
    spotsDao.save(favoriteSpot);
    redirectAttributes.addFlashAttribute("success", "Favorite Spot Saved Successfully");
//    <div class="alert alert-primary" role="alert" th:text="${success}" th:if="${success}"></div>
    return "redirect:/settings/";
  }

  @GetMapping("/favorite_spot/save/{id}")
  public void saveFavoriteSpot(@PathVariable long id){
    Spot favoriteSpot = spotsDao.getById(id);
    User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    User author = usersDao.getById(principal.getId());
    author.addSpot(favoriteSpot);
    spotsDao.save(favoriteSpot);
  }

  @PostMapping("/favorite_spot/create")
  public String insertFavoriteSpot(@ModelAttribute Spot spot) {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    spot.setUser(usersDao.getById(user.getId()));
    spotsDao.save(spot);
    return "redirect:/profile";
  }


}
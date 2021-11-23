package com.codeup.iknowaspot.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FavSpotController {
  @GetMapping("/favorite_spot")
  public String showFavoriteSpot(){ return "/favorite_spot"; }
}

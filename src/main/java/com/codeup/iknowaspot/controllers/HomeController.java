package com.codeup.iknowaspot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
class HomeController {

    @GetMapping("/")
    public String getSplashPage() {
        return "splash";
    }
    @GetMapping("/index")
    public String getIndexPage() {
        return "index";
    }
    @GetMapping("/aboutus")
    public String getAboutUsPage() {
        return "about-us";
    @GetMapping("/login")
    public String getLoginPage() {
        return "user-login";
    }

}


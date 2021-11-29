package com.codeup.iknowaspot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HomeController {

    @GetMapping("/")
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/aboutus")
    public String getAboutUsPage() {
        return "about-us";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        // Redirects to github login url
        // https://spring.io/guides/tutorials/spring-boot-oauth2/
        return "redirect:/oauth2/authorization/github";
    }

}


package com.codeup.iknowaspot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HomeController {

    @GetMapping("/index")
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/aboutus")
    public String getAboutUsPage() {
        return "about-us";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "user-login";
    }

}


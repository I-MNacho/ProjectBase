package com.codeup.iknowaspot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
class HomeController {

    @GetMapping("/")
    String index(Principal principal) {
        return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
    }
    @GetMapping("/index")
    public String getIndexPage() {
        return "index";
    }

}


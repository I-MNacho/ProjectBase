package com.codeup.iknowaspot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/splash")
    @ResponseBody
    public String homeMessage() {
        return "This is the landing page!";
    }
    @GetMapping("/index")
    public String getIndexPage() {
        return "index";
    }

}


package com.codeup.iknowaspot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HomeController {

//    @Value("${mapbox_key}")
//    private String mapboxApiKey;
//
//    @RequestMapping(path = "/keys.js", produces = "application/javascript")
//    @ResponseBody
//    public String apikey(){
//        System.out.println(mapboxApiKey);
//        return "const MapboxAPIKey = `" + mapboxApiKey + "`";
//    }

    @GetMapping("/index")
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/aboutus")
    public String getAboutUsPage() {
        return "about-us";
    }

}


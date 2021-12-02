package com.codeup.iknowaspot.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class HomeController {

    @Value("${mapbox.api.token}")
    private String mapboxApiKey;

    @Value("AAAgQ3espTiiSH4FxsWDIz")
    private String fileStackApiKey;

    @Value("2158f575ad5ab05573157f50c05cf4ca")
    private String openWeatherApiKey;

    @RequestMapping(path = "/keys.js", produces = "application/javascript")
    @ResponseBody
    public String apikey(){
        System.out.println(mapboxApiKey);
        return "const MapboxAPIKey = `" + mapboxApiKey + "`\n" 
                + "const FileStackAPIKey = `" + fileStackApiKey + "`";

    }

    @GetMapping("/index")
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/aboutus")
    public String getAboutUsPage() {
        return "about-us";
    }

}


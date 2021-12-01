package com.codeup.iknowaspot.controllers;
import com.codeup.iknowaspot.models.Spot;
import com.codeup.iknowaspot.repositories.SpotRepository;
import com.codeup.iknowaspot.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private SpotRepository spotsDao;

    public HomeController(SpotRepository spotDao) {
        this.spotsDao = spotDao;
    }



    @GetMapping("/home")
    public String getIndexPage(Model model) {
        model.addAttribute("spots", spotsDao.findAll());
        return "home";
    }

    @GetMapping("/aboutus")
    public String getAboutUsPage() {
        return "about-us";
    }

}


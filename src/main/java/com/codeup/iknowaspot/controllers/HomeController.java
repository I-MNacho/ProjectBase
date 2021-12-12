package com.codeup.iknowaspot.controllers;
import com.codeup.iknowaspot.models.Spot;
import com.codeup.iknowaspot.repositories.EventRepository;
import com.codeup.iknowaspot.repositories.SpotRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class HomeController {
    private SpotRepository spotsDao;
    private EventRepository eventsDao;

    public HomeController(SpotRepository spotDao, EventRepository eventsDao) {
        this.spotsDao = spotDao;
        this.eventsDao = eventsDao;
    }

    @Value("${mapbox.api.token}")
    private String mapboxApiKey;

    @Value("${filestack.api.token}")
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
    @GetMapping({"/"})
        public String getSplashPage(){
            return "partials/splash";
    }
    @GetMapping({"/home"})
    public String getIndexPage(Model model) {
        model.addAttribute("spots", spotsDao.findAll());
        model.addAttribute("events", eventsDao.findAll());
        Spot spot = new Spot();
        model.addAttribute("spot", spot);
        return "home";
    }

    @GetMapping("/aboutus")
    public String getAboutUsPage() {
        return "about-us";
    }

}


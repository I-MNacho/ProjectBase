package com.codeup.iknowaspot.controllers;
import com.codeup.iknowaspot.models.Spot;
import com.codeup.iknowaspot.models.User;
import com.codeup.iknowaspot.repositories.EventRepository;
import com.codeup.iknowaspot.repositories.SpotRepository;
import com.codeup.iknowaspot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class HomeController {
    private SpotRepository spotsDao;
    private EventRepository eventsDao;
    private UserRepository usersDao;

    public HomeController(SpotRepository spotDao, EventRepository eventsDao, UserRepository usersDao) {
        this.spotsDao = spotDao;
        this.eventsDao = eventsDao;
        this.usersDao = usersDao;
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
        return "const MapboxAPIKey = `" + mapboxApiKey + "`\n" 
                + "const FileStackAPIKey = `" + fileStackApiKey + "`";

    }
    @GetMapping({"/"})
        public String getSplashPage(){
            return "partials/splash";
    }
    @GetMapping({"/home"})
    public String getIndexPage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("userId", user.getId());
        }
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


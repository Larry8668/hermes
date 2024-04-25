package com.example.hermes.Home.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
    
    @GetMapping("/home")
    public ModelAndView homePage() {
        return new ModelAndView("home.html");
    }
}

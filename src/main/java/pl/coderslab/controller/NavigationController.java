package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavigationController {

    // strona główna
    @RequestMapping("/")
    public String homePage() {
        return "home";
    }
}

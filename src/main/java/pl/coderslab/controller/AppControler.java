package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import pl.coderslab.model.Admin;


@Controller
@RequestMapping("/app")
public class AppControler {

    @RequestMapping(path = "/app/dashboard", method = RequestMethod.GET)
    public String showDashboard(@SessionAttribute Admin admin, Model model) {
        return "dashboard";
    }
}

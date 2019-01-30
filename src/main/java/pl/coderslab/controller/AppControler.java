package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import pl.coderslab.model.Admin;
import pl.coderslab.repository.PlanRepository;
import pl.coderslab.repository.RecipeRepository;


@Controller
@RequestMapping("/app")
public class AppControler {
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    PlanRepository planRepository;

    @RequestMapping(path = "/dashboard", method = RequestMethod.GET)
    public String showDashboard(@SessionAttribute Admin admin, Model model) {
        model.addAttribute("recipeCount", recipeRepository.countByAdmin(admin));
        model.addAttribute("planCount", planRepository.countByAdmin(admin));
        System.out.println(planRepository.findFirstByAdminOrderByCreatedDesc(admin));
        return "dashboard";
    }

}

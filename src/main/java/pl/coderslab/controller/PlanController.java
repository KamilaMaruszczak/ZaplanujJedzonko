package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Plan;
import pl.coderslab.repository.PlanRepository;
import pl.coderslab.repository.RecipeRepository;

import javax.validation.Validator;
import java.util.List;


@Controller
public class PlanController {



    @Autowired
    Validator validator;


    @Autowired
    private PlanRepository planRepository;


    @Autowired
    private RecipeRepository recipeRepository;




    @ModelAttribute("plans")
    public List<Plan> getPlans(){


        return planRepository.findAll();


    }



    @RequestMapping(value = "/plans", produces = "text/html; charset=utf-8")
    public String viewPlans(Model model) {

        List<Plan> plans = planRepository.findAll();

        model.addAttribute("plans", plans);

        return "plans";



    }





























}

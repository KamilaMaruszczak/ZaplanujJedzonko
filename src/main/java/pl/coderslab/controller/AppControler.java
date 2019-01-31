package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Admin;
import pl.coderslab.model.DayName;
import pl.coderslab.model.Meal;
import pl.coderslab.model.Plan;
import pl.coderslab.repository.DayNameRepository;
import pl.coderslab.repository.MealRepository;
import pl.coderslab.repository.PlanRepository;
import pl.coderslab.repository.RecipeRepository;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;


@Controller
@RequestMapping("/app")
public class AppControler {
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    PlanRepository planRepository;
    @Autowired
    MealRepository mealRepository;
    @Autowired
    DayNameRepository dayNameRepository;

    @ModelAttribute("allDays")
    public List<DayName> dayNames() {
        return dayNameRepository.findAll();
    }

    @RequestMapping(path = "/dashboard", method = RequestMethod.GET)
    public String showDashboard(@SessionAttribute Admin admin, Model model) {
        model.addAttribute("recipeCount", recipeRepository.countByAdmin(admin));
        model.addAttribute("planCount", planRepository.countByAdmin(admin));
        Plan lastPlan = planRepository.findFirstByAdminOrderByCreatedDesc(admin);
        List<DayName> days = mealRepository.queryFindDistinctDaysByPlan(lastPlan);
        model.addAttribute("lastPlan", lastPlan);
        return "dashboard";
    }

    @RequestMapping(path = "/plan/add", method = RequestMethod.GET)
    public String addPlan() {
        return "add_plan";
    }

    @RequestMapping(path = "/plan/add", method = RequestMethod.POST)
    public String addPlan(@RequestParam String planName, @RequestParam String planDescription, @SessionAttribute Admin admin, Model model) {

        if (planName == null || planName.isEmpty()) {
            model.addAttribute("error", "Nazwa planu nie może być pusta.");
            return "add_plan";
        }
        Plan plan = new Plan();
        plan.setName(planName);
        plan.setDescription(planDescription);
        plan.setCreated(LocalDateTime.now());
        plan.setAdmin(admin);
        planRepository.save(plan);

        return "redirect: /app/dashboard";

    }

    public void addToModel(Admin admin, Model model) {
        model.addAttribute("plans", planRepository.findAllByAdmin(admin));
        model.addAttribute("recipies", recipeRepository.findAllByAdmin(admin));
    }

    @RequestMapping(path = "/recipe/plan/add", method = RequestMethod.GET)
    public String addMeal(Model model, @SessionAttribute Admin admin) {
        model.addAttribute("meal", new Meal());
        addToModel(admin, model);
        return "add_meal";
    }

    @RequestMapping(path = "/recipe/plan/add", method = RequestMethod.POST)
    public String addMeal(@Valid Meal meal, BindingResult result, Model model, @SessionAttribute Admin admin) {

        if (result.hasErrors()) {
            addToModel(admin, model);
            return "add_meal";
        }
        mealRepository.save(meal);
        return "redirect: /app/dashboard";
    }


}

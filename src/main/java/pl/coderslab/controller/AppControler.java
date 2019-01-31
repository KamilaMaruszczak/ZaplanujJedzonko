package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import pl.coderslab.model.Admin;
import pl.coderslab.model.DayName;
import pl.coderslab.model.Plan;
import pl.coderslab.repository.MealRepository;
import pl.coderslab.repository.PlanRepository;
import pl.coderslab.repository.RecipeRepository;

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

    @RequestMapping(path = "/dashboard", method = RequestMethod.GET)
    public String showDashboard(@SessionAttribute Admin admin, Model model) {
        model.addAttribute("recipeCount", recipeRepository.countByAdmin(admin));
        model.addAttribute("planCount", planRepository.countByAdmin(admin));
        Plan lastPlan = planRepository.findFirstByAdminOrderByCreatedDesc(admin);
        model.addAttribute("lastPlan", lastPlan);
        List<DayName> days = mealRepository.queryFindDistinctDaysByPlan(lastPlan);
        model.addAttribute("days", days);
        System.out.println(days.size());
        for (DayName d:days) {
            model.addAttribute("meals"+days.indexOf(d), mealRepository.findByDayNameAndPlanOrderByMealOrder(d, lastPlan));
        }
        return "dashboard";
    }

    @RequestMapping(path = "/addplan", method = RequestMethod.GET)
    public String addPlan() {
        return "add_plan";
    }

    @RequestMapping(path = "/addplan", method = RequestMethod.POST)
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

}

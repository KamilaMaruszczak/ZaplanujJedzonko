package pl.coderslab.controller;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.model.Recipe;
import pl.coderslab.repository.PlanRepository;
import pl.coderslab.repository.RecipeRepository;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;

@Controller
@RequestMapping("/recipe")
public class RecipeController {



    @Autowired
    Validator validator;



    @Autowired
    private RecipeRepository recipeRepository;


    @Autowired
    private PlanRepository planRepository;



    @ModelAttribute("recipes")
    public List<Recipe> getRecipes(){


        return recipeRepository.findAll();


    }


    @RequestMapping(value = "/list", produces = "text/html; charset=utf-8")
    public String viewRecipes(Model model) {

        List<Recipe> recipes = recipeRepository.findAll();

        model.addAttribute("recipes", recipes);

        return "/recipe/list";



    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addRecipe(Model model){

        model.addAttribute("recipe", new Recipe());

        return "/recipe/add";



    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addRecipe(@Valid Recipe recipe, BindingResult result) {

        if (result.hasErrors()) {

            return "/recipe/add";

        }

        recipeRepository.save(recipe);



        return "redirect:/recipe/list";


    }



    @RequestMapping(value = "/details")
    public String details(@RequestParam long id, Model model){


        Recipe details = recipeRepository.findOne(id);

        model.addAttribute("details", details);


        return "/recipe/details";



    }
















}

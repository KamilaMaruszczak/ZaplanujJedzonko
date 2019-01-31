package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.Recipe;
import pl.coderslab.repository.RecipeRepository;

public class RecipeConverter implements Converter<String, Recipe> {

    @Autowired
    RecipeRepository recipeRepository;

    @Override
    public Recipe convert(String s) {
        return recipeRepository.findOne(Long.parseLong(s));
    }
}

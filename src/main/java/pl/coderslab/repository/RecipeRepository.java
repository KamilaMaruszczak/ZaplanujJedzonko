package pl.coderslab.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Recipe;

import java.util.List;


public interface RecipeRepository extends JpaRepository<Recipe, Long> {



    List<Recipe> countByAdminId(Long userId);








}

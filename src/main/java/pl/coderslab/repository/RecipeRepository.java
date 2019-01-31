package pl.coderslab.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Admin;
import pl.coderslab.model.Recipe;

import java.util.List;


public interface RecipeRepository extends JpaRepository<Recipe, Long> {



    long countByAdmin(Admin admin);

    List<Recipe> findAllByAdmin(Admin admin);








}

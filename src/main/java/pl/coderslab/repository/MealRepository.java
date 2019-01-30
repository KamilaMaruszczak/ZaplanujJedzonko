package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Admin;
import pl.coderslab.model.DayName;
import pl.coderslab.model.Meal;
import pl.coderslab.model.Plan;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long> {

    List<DayName> findDistinctByPlan(Plan plan);

}

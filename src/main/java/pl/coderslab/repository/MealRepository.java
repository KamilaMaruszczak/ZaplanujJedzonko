package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.model.Admin;
import pl.coderslab.model.DayName;
import pl.coderslab.model.Meal;
import pl.coderslab.model.Plan;

import java.time.LocalDate;
import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long> {

    @Query("select distinct m.dayName from Meal m where m.plan = ?1 order by m.dayName.dayOrder")
    List<DayName> queryFindDistinctDaysByPlan(Plan plan);

    List<Meal> findByDayNameAndPlanOrderByMealOrder(DayName d, Plan lastPlan);
    int countByRecipeId(Long id);
}

package pl.coderslab.model;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;
import pl.coderslab.validator.NotEquals;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "meals")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "meal_name")
    private String mealName;

    @NotEquals(rejectValues = 0, message = "nie może być 0")
    @NumberFormat
    @Column(name = "meal_order")
    private int mealOrder;

    @NotNull
    @ManyToOne
    private DayName dayName;

    @NotNull
    @ManyToOne
    private Recipe recipe;

    @NotNull
    @ManyToOne
    private Plan plan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public int getMealOrder() {
        return mealOrder;
    }

    public void setMealOrder(int mealOrder) {
        this.mealOrder = mealOrder;
    }

    public DayName getDayName() {
        return dayName;
    }

    public void setDayName(DayName dayName) {
        this.dayName = dayName;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }
}

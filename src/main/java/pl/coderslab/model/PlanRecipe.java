package pl.coderslab.model;

import org.hibernate.mapping.ToOne;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "plan_recipe")
public class PlanRecipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String mealname;

    @NotNull
    private int order;

    @OneToMany(fetch = FetchType.EAGER)
    private List<DayName> daynames;

    @OneToMany
    private List<Recipe> recipies;

    @ManyToOne
    private Plan plan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMealname() {
        return mealname;
    }

    public void setMealname(String mealname) {
        this.mealname = mealname;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public List<DayName> getDaynames() {
        return daynames;
    }

    public void setDaynames(List<DayName> daynames) {
        this.daynames = daynames;
    }

    public List<Recipe> getRecipies() {
        return recipies;
    }

    public void setRecipies(List<Recipe> recipies) {
        this.recipies = recipies;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    @Override
    public String toString() {
        return "PlanRecipe{" +
                "id=" + id +
                ", mealname='" + mealname + '\'' +
                ", order=" + order +
                '}';
    }
}

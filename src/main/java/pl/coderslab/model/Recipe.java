package pl.coderslab.model;



import org.hibernate.validator.constraints.NotBlank;


import javax.persistence.*;

import java.time.LocalDateTime;

import java.util.Date;



@Entity
public class Recipe {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank
    private String name;

    @NotBlank
    private String ingredients;


    @NotBlank
    private String description;


    private LocalDateTime created;


    private LocalDateTime updated;

    @Column(name = "preparation_time")
    private int preparationtime;


    @ManyToOne
    private Admin admin;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public int getPreparationtime() {
        return preparationtime;
    }

    public void setPreparationtime(int preparationtime) {
        this.preparationtime = preparationtime;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }


    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", preparationtime=" + preparationtime +
                ", admin=" + admin +
                '}';






    }






















}

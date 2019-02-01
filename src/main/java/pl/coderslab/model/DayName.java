package pl.coderslab.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "day_name")
public class DayName {

    @Id
    private Long id;

    @NotBlank
    private String name;

    @Column(name="day_order")
    private int dayOrder;


    public DayName() {
    }

    public DayName(Long id, String name, int order) {
        this.id = id;
        this.name = name;
        this.dayOrder = order;
    }

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

    public int getDayOrder() {
        return dayOrder;
    }

    public void setDayOrder(int dayOrder) {
        this.dayOrder = dayOrder;
    }

    @Override
    public String toString() {
        return "DayName{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", order=" + dayOrder +
                '}';
    }
}


package com.softuni.battleships.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "ships")
public class Ship extends BaseEntity{
    @PastOrPresent
    private LocalDate created;
    @Positive
    @Column(nullable = false)
    private Long health;

    @Size(min = 3, max = 10)
    @Column(unique = true, nullable = false)
    private String name;

    @Positive
    @Column(nullable = false)
    private Long power;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;

    public Ship() {}

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public Long getHealth() {
        return health;
    }

    public void setHealth(Long health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

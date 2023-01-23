package com.softuni.battleships.models;

import com.softuni.battleships.models.enums.ShipType;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    @Enumerated(EnumType.ORDINAL)
    @Column(unique = true, nullable = false)
    private ShipType name;

    @Column(columnDefinition = "text")
    private String description;

    public Category() {}
    public Category(ShipType name) {
        this.name = name;
    }


    public ShipType getName() {
        return name;
    }

    public void setName(ShipType name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

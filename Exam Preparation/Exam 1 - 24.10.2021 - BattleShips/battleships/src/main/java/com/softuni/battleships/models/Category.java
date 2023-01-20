package com.softuni.battleships.models;

import com.softuni.battleships.models.enums.Name;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    @Enumerated(EnumType.ORDINAL)
    @Column(unique = true, nullable = false)
    private Name name;

    @Column(columnDefinition = "text")
    private String description;

    public Category() {}
    public Category(Name name) {
        this.name = name;
    }


    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

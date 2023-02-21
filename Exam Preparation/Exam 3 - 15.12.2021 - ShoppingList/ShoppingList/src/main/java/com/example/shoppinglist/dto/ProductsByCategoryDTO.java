package com.example.shoppinglist.dto;

import java.util.Set;

public class ProductsByCategoryDTO {

    private Set<ProductDTO> foods;
    private Set<ProductDTO> drinks;
    private Set<ProductDTO> households;
    private Set<ProductDTO> others;

    public ProductsByCategoryDTO() {}

    public Set<ProductDTO> getFoods() {
        return foods;
    }

    public void setFoods(Set<ProductDTO> foods) {
        this.foods = foods;
    }

    public Set<ProductDTO> getDrinks() {
        return drinks;
    }

    public void setDrinks(Set<ProductDTO> drinks) {
        this.drinks = drinks;
    }

    public Set<ProductDTO> getHouseholds() {
        return households;
    }

    public void setHouseholds(Set<ProductDTO> households) {
        this.households = households;
    }

    public Set<ProductDTO> getOthers() {
        return others;
    }

    public void setOthers(Set<ProductDTO> others) {
        this.others = others;
    }
}

package com.example.shoppinglist.model;

public enum NameEnum {

    FOOD ("Food"),

    DRINK ("Drink"),

    HOUSE ("Household"),

    OTHER ("Other");

    private final String value;


    NameEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}


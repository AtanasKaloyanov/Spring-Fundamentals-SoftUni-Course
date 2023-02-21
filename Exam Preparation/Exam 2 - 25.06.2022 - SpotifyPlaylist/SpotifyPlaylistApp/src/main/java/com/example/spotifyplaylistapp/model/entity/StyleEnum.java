package com.example.spotifyplaylistapp.model.entity;


public enum StyleEnum {

    POP ("POP"),

    ROCK ("ROCK"),

    JAZZ ("JAZZ");

    private final String value;


    StyleEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}


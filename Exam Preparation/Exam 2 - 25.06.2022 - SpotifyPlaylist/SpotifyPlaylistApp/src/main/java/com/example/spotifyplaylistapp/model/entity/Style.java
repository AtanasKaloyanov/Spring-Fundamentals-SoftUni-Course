package com.example.spotifyplaylistapp.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "styles")
public class Style extends BaseEntity{

    @Column
    @Enumerated(EnumType.STRING)
    private StyleEnum styleEnum;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "style", fetch = FetchType.EAGER)
    private Set<Song> songs;

    public Style() {}

    public StyleEnum getStyleEnum() {
        return styleEnum;
    }

    public void setStyleEnum(StyleEnum styleEnum) {
        this.styleEnum = styleEnum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }


}

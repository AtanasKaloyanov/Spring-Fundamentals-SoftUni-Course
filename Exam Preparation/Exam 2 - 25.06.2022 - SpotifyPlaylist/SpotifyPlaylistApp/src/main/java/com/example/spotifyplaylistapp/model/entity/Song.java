package com.example.spotifyplaylistapp.model.entity;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "songs")
public class Song extends BaseEntity {
    @Size(min = 3, max = 20)
    @Column(nullable = false)
    private String performer;

    @Size(min = 2, max = 20)
    @Column(nullable = false)
    private String title;

    @Positive
    @Column(nullable = false)
    private Long duration;
    @PastOrPresent
    @Column
    private LocalDate releaseDate;
    @ManyToOne()
    private Style style;

    @ManyToMany(mappedBy = "songs", fetch = FetchType.EAGER)
    private Set<User> users;

    public Song() {
        this.users = new HashSet<>();
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

   public String toMinutes() {
        Long minutes = duration / 60;
        Long seconds = duration % 60;

        return String.format("%d:%d", minutes, seconds);
   }
}

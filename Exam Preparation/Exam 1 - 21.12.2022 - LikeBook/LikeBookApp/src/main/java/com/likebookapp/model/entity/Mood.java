package com.likebookapp.model.entity;

import com.fasterxml.jackson.databind.ser.Serializers;

import javax.persistence.*;
import java.util.Set;

@Table(name = "moods")
@Entity
public class Mood extends BaseEntity {


    @Enumerated(EnumType.STRING)
    private MoodsEnum moodName;

    @Column(columnDefinition = "TEXT")
   private String description;

    @OneToMany(mappedBy = "mood", fetch = FetchType.EAGER)
    private Set<Post> moodPosts;

   public Mood() {}

    public MoodsEnum getMoodName() {
        return moodName;
    }

    public void setMoodName(MoodsEnum moodName) {
        this.moodName = moodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package com.likebookapp.model.dto;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.User;

import java.util.Set;

public class PostsDTO {
    private Long id;

    private String content;

    private Mood mood;

    private User user;

    private Set<User> userLikes;
    private int likes;

    public PostsDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Set<User> getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(Set<User> userLikes) {
        this.userLikes = userLikes;
    }
}

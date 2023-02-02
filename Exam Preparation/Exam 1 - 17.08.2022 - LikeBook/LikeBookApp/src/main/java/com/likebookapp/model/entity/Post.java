package com.likebookapp.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post extends BaseEntity {

    @Size(min = 2, max = 150)
    @Column(nullable = false)
    private String content;

    @ManyToOne()
    private User user;

    @ManyToMany
    private List<User> likes;

    // 1 пост -> 1 юзер
    // 1 юзер -> много постове
}

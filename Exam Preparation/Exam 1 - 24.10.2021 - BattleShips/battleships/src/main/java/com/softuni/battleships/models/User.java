package com.softuni.battleships.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Size(min = 3, max = 10)
    @Column(unique = true, nullable = false)
    private String username;

    @Size(min = 5, max = 20)
    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Email
    @Column(unique = true, nullable = false)
    private String email;
    @Size(min = 3)
    @Column(nullable = false)
    private String password;


    public User() {}
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

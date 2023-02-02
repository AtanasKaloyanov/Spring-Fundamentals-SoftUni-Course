package com.likebookapp.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Size(min = 3, max = 20)
    @Column(name = "Username", unique = true, nullable = false)
    private String username;

    @Size(min = 3, max = 20)
    @Column(name = "Password", nullable = false)
    private String password;

    @Email
    @Column(name = "Email", nullable = false)
    private String email;

    public User() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

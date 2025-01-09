package com.jwt.authentication.models;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class User {
    private @Id @GeneratedValue Long id;
    private String name;
    private String password;
    private boolean admin;

    User() {}

    User(Long id, String name, String password, boolean admin) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.admin = admin;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean getAdmin() {
        return admin;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if(!(o instanceof User)) {
            return false;
        }

        User u = (User) o;
        return Objects.equals(this.id, u.id)
            && Objects.equals(this.name, u.name)
            && Objects.equals(this.password, u.password)
            && Objects.equals(this.admin, u.admin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.password, this.admin);
    }
    
    @Override
    public String toString() {
        return "User{id=" + this.id + ", name=" + this.name + ", password=" + this.password 
            + ", admin=" + this.admin + "}";
    }
}

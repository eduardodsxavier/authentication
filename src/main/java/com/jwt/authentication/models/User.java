package com.jwt.authentication.models;

import java.util.Objects;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.JWT;
import java.util.Map;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {
    private @Id @GeneratedValue Long id;
    private String name;
    private int password;
    private boolean admin;
    private String jwt;

    User() {}

    User(Long id, String name, String password, boolean admin) {
        this.id = id;
        this.name = name;
        this.password = Objects.hash(password);
        this.admin = admin;
        setJwt();
    }

    public void setId(Long id) {
        this.id = id;
        setJwt();
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
        setJwt();
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = Objects.hash(password);
        setJwt();
    }

    public int getPassword() {
        return password;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
        setJwt();
    }

    public boolean getAdmin() {
        return admin;
    }

    public void setJwt() {
        this.jwt = JWT.create()
            .withHeader(Map.of("alg", "HS256", "typ", "JWT"))
            .withClaim("id", id)
            .withClaim("name", name)
            .withClaim("password", password)
            .withClaim("admin", admin)
            .sign(Algorithm.HMAC256("secret"));
    }

    public String getJwt() {
        return jwt;
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
    public String toString() {
        return "User{id=" + this.id + ", name=" + this.name + ", password=" + this.password 
            + ", admin=" + this.admin + "}";
    }
}

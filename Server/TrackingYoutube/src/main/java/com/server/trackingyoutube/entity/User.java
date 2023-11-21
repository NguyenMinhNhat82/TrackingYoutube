package com.server.trackingyoutube.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


import java.util.Collection;

@Entity
@Table(name = "users")
public class User {

    @Id
    private String id;

    private String email;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String id, String email) {
        this.id = id;
        this.email = email;

    }
    public User(){}
}

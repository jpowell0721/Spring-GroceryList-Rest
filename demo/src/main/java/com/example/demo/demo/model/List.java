package com.example.demo.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

import java.util.Iterator;

@Entity // This tells Hibernate to make a table out of this class
public class List {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String listName;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return listName;
    }

    public void setName(String name) {
        this.listName = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
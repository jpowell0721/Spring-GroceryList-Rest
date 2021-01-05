package com.example.demo.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class ListItem {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String itemName;

    @ManyToOne
    @JoinColumn(name="item_id")
    private List list;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return itemName;
    }

    public void setName(String name) {
        this.itemName = name;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}

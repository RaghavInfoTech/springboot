package com.info.springboot.crud.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Sample Book object with two properties
 * @author Raghava
 */
public class Book implements Serializable {

    private int id;


    private String name;

    public Book(@JsonProperty("id")int id, @JsonProperty("name")String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

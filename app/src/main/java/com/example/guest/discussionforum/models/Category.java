package com.example.guest.discussionforum.models;

/**
 * Created by Guest on 12/5/16.
 */
public class Category {
    private String name;
    private String description;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Category() {}


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

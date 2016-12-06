package com.example.guest.discussionforum.models;

import org.parceler.Parcel;

/**
 * Created by Guest on 12/5/16.
 */

@Parcel
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

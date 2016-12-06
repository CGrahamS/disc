package com.example.guest.discussionforum.models;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guest on 12/5/16.
 */

@Parcel
public class Category {
    private String name;
    private String description;
    private List<String> posts = new ArrayList<>();

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

    public List<String> getPosts() {
        return posts;
    }

}

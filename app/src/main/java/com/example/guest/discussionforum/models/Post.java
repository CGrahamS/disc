package com.example.guest.discussionforum.models;

import java.security.Timestamp;

/**
 * Created by Guest on 12/6/16.
 */
public class Post {
    private String postTitle;
    private String postContent;
    private String parentCategory;
//    private Timestamp postTime;

//    public Post(String postTitle, String postContent, Timestamp postTime) {
//        this.postTitle = postTitle;
//        this.postContent = postContent;
//        this.postTime = postTime;
//    }

    public Post() {}

    public Post(String postTitle, String postContent, String parentCategory) {
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.parentCategory = parentCategory;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public String getParentCategory() {
        return parentCategory;
    }

//    public Timestamp getPostTime() {
//        return postTime;
//    }
}

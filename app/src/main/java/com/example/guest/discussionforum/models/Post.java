package com.example.guest.discussionforum.models;

/**
 * Created by Guest on 12/6/16.
 */
public class Post {
    private String postTitle;
    private String postContent;
    private String categoryId;
//    private Timestamp postTime;

//    public Post(String postTitle, String postContent, Timestamp postTime) {
//        this.postTitle = postTitle;
//        this.postContent = postContent;
//        this.postTime = postTime;
//    }

    public Post() {}

    public Post(String postTitle, String postContent, String categoryId) {
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.categoryId = categoryId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public String getCategoryId() {
        return categoryId;
    }

//    public Timestamp getPostTime() {
//        return postTime;
//    }
}

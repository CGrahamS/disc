package com.example.guest.discussionforum.models;

import java.security.Timestamp;

/**
 * Created by Guest on 12/6/16.
 */
public class Post {
    private String postTitle;
    private String postContent;
    private Timestamp postTime;

    public Post(String postTitle, String postContent, Timestamp postTime) {
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postTime = postTime;
    }

    public Post(String postTitle, String postContent) {
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postTime = postTime;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public Timestamp getPostTime() {
        return postTime;
    }
}

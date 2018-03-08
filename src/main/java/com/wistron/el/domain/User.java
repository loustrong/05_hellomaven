package com.wistron.el.domain;

public class User {
    
    /**
     * 兴趣爱好
     */
    private String likes[];
    
    public String[] getLikes() {
        return likes;
    }

    public void setLikes(String[] likes) {
        this.likes = likes;
    }
}
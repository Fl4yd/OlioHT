package com.example.olioht;

public class Review {
    private String username;
    private String reviewtext;

    public Review(String Username, String reviewtext) {
        this.username = Username;
        this.reviewtext = reviewtext;
    }

    public String getUsername() {
        return username;
    }

    public String getReviewtext() {
        return reviewtext;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setReviewtext(String reviewtext) {
        this.reviewtext = reviewtext;
    }
}
/* näistä osasista koostuu ReviewSingletonin array list,
 uudet arvostelut luodaan uudella public Reviewillä joka lisätään listaan */
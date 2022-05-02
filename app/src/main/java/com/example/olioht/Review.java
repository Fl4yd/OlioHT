package com.example.olioht;

public class Review {
    private String username;
    private String reviewtext;
    private String rating;



    public Review(String Username, String reviewtext, String rating) {
        this.username = Username;
        this.reviewtext = reviewtext;
        this.rating = rating;
    }

    public String getRating() { return rating; }

    public void setRating(String rating) { this.rating = rating; }

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
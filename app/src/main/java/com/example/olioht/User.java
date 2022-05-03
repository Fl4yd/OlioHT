package com.example.olioht;

import java.io.Serializable;
import java.util.ArrayList;


    //Object to store user information
public class User implements Serializable {
    private String mUser;
    private String mTheatre;
    private String mName;
    private int mAge;

    // The Arraylist for the reviews made by this specific user(this is for the movie history)
    ArrayList<Review> reviews = new ArrayList<>();

    public User(String mUser, String mTheatre, String mName, int mAge) {
        this.mUser = mUser;
        this.mTheatre = mTheatre;
        this.mName = mName;
        this.mAge = mAge;
    }

    public String getmUser() {
        return mUser;
    }

    public String getmTheatre() {
        return mTheatre;
    }

    public void setmTheatre(String mTheatre) {
        this.mTheatre = mTheatre;
    }

    public String getmName() {
        return mName;
    }

    public int getmAge() {
        return mAge;
    }



    public ArrayList<Review> getReviews() {return this.reviews;}
    public void addReview(Review review) {reviews.add(review);};

}

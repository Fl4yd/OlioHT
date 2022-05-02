package com.example.olioht;

import java.io.Serializable;
import java.util.ArrayList;

//Object class to store movie information and have methods to retrieve data
public class movie implements Serializable {
    private String name;
    private String time;
    private int releaseYear;
    private int duration;
    private String ageLimit;
    private int ID;
    private String picURL;
    private String actors;
    private String directors;
    private String synopsis;
    private ArrayList<Review> reviews = new ArrayList<>();

    public movie(String name, String time, int releaseYear, int duration, String ageLimit, int ID, String picURL, String actors, String directors, String synopsis) {
        this.name = name;
        this.time = time;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.ageLimit = ageLimit;
        this.ID = ID;
        this.picURL = picURL;
        this.actors = actors;
        this.directors = directors;
        this.synopsis = synopsis;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getReleaseYear() { return releaseYear; }

    public int getDuration() { return duration; }

    public String getAgeLimit() { return ageLimit; }

    public int getID() { return ID; }
    public void setID(int ID) { this.ID = ID; }

    public String getPicURL() {return picURL;}

    public String getActors() {return actors;}

    public String getDirectors() {return directors;}

    public String getSynopsis() {return this.synopsis;}

    public ArrayList<Review> getReviews() {return this.reviews;}
    public void addReview(Review review) {reviews.add(review);
    }


}

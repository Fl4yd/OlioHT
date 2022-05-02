package com.example.olioht;

import java.io.Serializable;
import java.util.ArrayList;

public class movie implements Serializable {
    private String name;
    private String time;
    private int releaseYear;
    private int duration;
    private String ageLimit;
    private String genres;
    private int ID;
    private String picText;
    private String picURL;
    private String actors;
    private String directors;
    private String synopsis;
    private ArrayList<Review> reviews = new ArrayList<Review>();

    public movie(String name, String time, int releaseYear, int duration, String ageLimit, String genres, int ID, String picText, String picURL, String actors, String directors, String synopsis) {
        this.name = name;
        this.time = time;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.ageLimit = ageLimit;
        this.genres = genres;
        this.ID = ID;
        this.picText = picText;
        this.picURL = picURL;
        this.actors = actors;
        this.directors = directors;
        this.synopsis = synopsis;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public int getReleaseYear() { return releaseYear; }
    public void setReleaseYear(int releaseYear) { this.releaseYear = releaseYear; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public String getAgeLimit() { return ageLimit; }
    public void setAgeLimit(String ageLimit) { this.ageLimit = ageLimit; }

    public int getID() { return ID; }
    public void setID(int ID) { this.ID = ID; }

    //public ArrayList<String> getGenres() { return genres; }
    //public void setGenres(ArrayList<String> genres) { this.genres = genres; }

    public String getPicText() { return picText; }
    public void setPicText(String picText) { this.picText = picText; }

    public String getPicURL() {return picURL;}
    public void setPicURL(String picText) { this.picURL = picURL; }

    public String getActors() {return actors;}
    public void setActors(String actors) { this.actors = actors; }

    public String getDirectors() {return directors;}
    public void setDirectors(String directors) { this.directors = directors; }

    public String getSynopsis() {return this.synopsis;}
    public void setSynopsis(String synopsis) { this.synopsis = synopsis; }

    public ArrayList<Review> getReviews() {return this.reviews;}
    public void addReview(Review review) {reviews.add(review);
    }


}

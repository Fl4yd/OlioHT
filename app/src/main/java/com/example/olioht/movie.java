package com.example.olioht;

import java.util.ArrayList;

public class movie {
    private String name;
    private String time;
    private int releaseYear;
    private int duration;
    private int ageLimit;
    private ArrayList<String> genres = new ArrayList<String>();
    private int ID;
    private String picText;

    public movie(String name, String time, int releaseYear, int duration, int ageLimit, ArrayList<String> genres, int ID, String picText) {
        this.name = name;
        this.time = time;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.ageLimit = ageLimit;
        this.genres = genres;
        this.ID = ID;
        this.picText = picText;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public int getReleaseYear() { return releaseYear; }
    public void setReleaseYear(int releaseYear) { this.releaseYear = releaseYear; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public int getAgeLimit() { return ageLimit; }
    public void setAgeLimit(int ageLimit) { this.ageLimit = ageLimit; }

    public int getID() { return ID; }
    public void setID(int ID) { this.ID = ID; }

    public ArrayList<String> getGenres() { return genres; }
    public void setGenres(ArrayList genres) { this.genres = genres; }

    public String getPicText() { return picText; }
    public void setPicText(String picText) { this.picText = picText; }

}

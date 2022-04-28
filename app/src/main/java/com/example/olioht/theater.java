package com.example.olioht;

import java.util.ArrayList;

public class theater {
    private ArrayList<movie> movies = new ArrayList<movie>();

    public theater() {

    }

    public void addMovie(String name, String time, int releaseYear, int duration, String ageLimit, String genres, int ID, String picText, String picURL, String actors, String directors) {

        movies.add(new movie(name, time, releaseYear, duration, ageLimit, genres, ID, picText, picURL, actors, directors));
    }
}

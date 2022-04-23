package com.example.olioht;

import java.util.ArrayList;

public class theater {
    private ArrayList<movie> movies = new ArrayList<movie>();

    public theater() {

    }

    public void addMovie(String name, String time, int releaseYear, int duration, int ageLimit, ArrayList<String> genres, int ID, String picText) {

        movies.add(new movie(name, time, releaseYear, duration, ageLimit, genres, ID, picText));
    }
}

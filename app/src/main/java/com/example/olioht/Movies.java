package com.example.olioht;

import java.util.HashMap;

public class Movies {

    private static Movies Movies_instance = null;

    HashMap<Integer, movie> movies = new HashMap<Integer, movie>();


    private Movies() {

    }

    public static Movies getInstance() {
        if (Movies_instance == null) {
            Movies_instance = new Movies();
        }

        return Movies_instance;
    }
    public void addMovie(int ID, movie Movie) {
        movies.put(ID, Movie);
    }
    public movie searchMovie(int ID) {
        movie Movie = movies.get(ID);
        if(Movie != null) {
            return Movie;
        }
        else {
            return null;
        }
    }

}
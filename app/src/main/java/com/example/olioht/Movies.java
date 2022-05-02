package com.example.olioht;

import java.io.Serializable;
import java.util.HashMap;

public class Movies extends HashMap<String, User> implements Serializable {

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
        return Movie;
    }

}

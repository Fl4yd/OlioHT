package com.example.olioht;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Movies extends HashMap<String, User> implements Serializable {

    private static Movies Movies_instance = null;

    HashMap<Integer, movie> movies = new HashMap<Integer, movie>();
    ArrayList<movie> moviesArrayList = new ArrayList<movie>();


    private Movies() {

    }

    public static Movies getInstance() {
        if (Movies_instance == null ) {
            Movies_instance = new Movies();
        }
        return Movies_instance;
    }
    public void addMovie(int ID, movie Movie) {
        movies.put(ID, Movie);
        moviesArrayList.add(Movie);
    }
    public movie searchMovie(int ID) {
        movie Movie = movies.get(ID);
        return Movie;
    }

    public Boolean contains(String string) {
        for (int i = 0; i < movies.size(); i++) {
            if (moviesArrayList.get(i).getName().contains(string)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<movie> getArrayList() {
        return this.moviesArrayList;
    }

}

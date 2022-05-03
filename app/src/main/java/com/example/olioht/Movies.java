package com.example.olioht;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;


//Singleton for the movies
public class Movies {

    private static Movies Movies_instance = null;

    HashMap<Integer, movie> movies = new HashMap<Integer, movie>();
    ArrayList<movie> moviesArrayList = new ArrayList<movie>();
    ArrayList<movie> ageLimitedArrayList;


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
        if(Movie != null) {
            return Movie;
        }
            return null;
    }
    public ArrayList<movie> getAgeLimitedList(int age) {
        this.ageLimitedArrayList = new ArrayList<movie>();
        System.out.println(this.moviesArrayList.size());
        for (movie item : this.moviesArrayList) {
            if (item.getAgeLimit() <= age) {
                this.ageLimitedArrayList.add(item);
            }
        }
        System.out.println(this.ageLimitedArrayList.size());
        return this.ageLimitedArrayList;
    }
    public ArrayList<movie> getFilteredList(String text) {
        ArrayList<movie> temp = new ArrayList<movie>();
        for (movie item : this.ageLimitedArrayList) {
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                temp.add(item);
            }
        }
        return temp;
    }


    public ArrayList<movie> getArrayList() {
        return this.moviesArrayList;
    }

}

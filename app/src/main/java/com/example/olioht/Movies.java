package com.example.olioht;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Movies implements Serializable {

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
        if(Movie != null) {
            return Movie;
        }
            return null;
    }

    public void loadData(Context context) {
        try {

            FileInputStream fis1 = context.openFileInput("movieHashMap.txt");
            FileInputStream fis2 = context.openFileInput("movieArrayList.txt");
            ObjectInputStream ois1 = new ObjectInputStream(fis1);
            ObjectInputStream ois2 = new ObjectInputStream(fis2);
            this.movies = (HashMap) ois1.readObject();
            this.moviesArrayList = (ArrayList<movie>) ois2.readObject();
            fis1.close();
            fis2.close();
            ois1.close();
            fis2.close();
            System.out.println("Data has been loaded");
        } catch (IOException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void saveData(Context context) {
        try {
            FileOutputStream fos1 = context.openFileOutput("movieHashMap.txt", Context.MODE_PRIVATE);
            FileOutputStream fos2 = context.openFileOutput("movieArrayList.txt", Context.MODE_PRIVATE);

            ObjectOutputStream ous1 = new ObjectOutputStream(fos1);
            ObjectOutputStream ous2 = new ObjectOutputStream(fos2);
            ous1.writeObject(this.movies);
            ous2.writeObject(this.moviesArrayList);
            fos1.close();
            fos2.close();
            ous1.close();
            ous2.close();
            System.out.println("Data has been saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<movie> getArrayList() {
        return this.moviesArrayList;
    }

}

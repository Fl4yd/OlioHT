package com.example.olioht;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
// Theatre Singleton for the spinners, has the name and the theatre ID
public class TheaterSingleton implements Serializable {
    private List<Theatre> Theaters;

    private TheaterSingleton() {
        Theaters = new ArrayList<>();
    }

    public void AddTheaterString(String name, String ID) {
        Theaters.add(new Theatre(name, ID));
    }

    public List<Theatre> getTheaters() {
        return (Theaters);
    }

    private static TheaterSingleton TheatersBase;

    // When you want to get or add information from or to the arraylist of theaters, this method checks if the object is already created
    // if not, it creates it here privately
    public static TheaterSingleton get() {
        if (TheatersBase == null) {
            TheatersBase = new TheaterSingleton();
        }
        return (TheatersBase);
    }
}



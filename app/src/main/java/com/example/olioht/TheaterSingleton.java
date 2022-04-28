package com.example.olioht;

import java.util.ArrayList;
import java.util.List;

public class TheaterSingleton {
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

    public static TheaterSingleton get() {
        if (TheatersBase == null) {
            TheatersBase = new TheaterSingleton();
        }
        return (TheatersBase);
    }
}



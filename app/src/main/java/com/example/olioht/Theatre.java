package com.example.olioht;

//Object class for theatre for the spinner
public class Theatre {
    private String name;
    private String ID;

    public Theatre(String name, String ID) {
        this.name = name;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    @Override
    public String toString() {
        return name;
    }
}


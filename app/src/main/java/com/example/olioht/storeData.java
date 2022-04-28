package com.example.olioht;

public class storeData {
    private String ID;
    private String name;

    public storeData() {
        ID = "";
        name = "";
    }

    public void storeData(String name){
        this.ID = ID;
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.example.olioht;

public class User {
    private String mUser;
    private String mTheatre;
    private String mName;
    private int mAge;

    public User(String mUser, String mTheatre, String mName, int mAge) {
        this.mUser = mUser;
        this.mTheatre = mTheatre;
        this.mName = mName;
        this.mAge = mAge;
    }



    public String getmUser() {
        return mUser;
    }

    public void setmUser(String mUser) {
        this.mUser = mUser;
    }

    public String getmTheatre() {
        return mTheatre;
    }

    public void setmTheatre(String mTheatre) {
        this.mTheatre = mTheatre;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmAge() {
        return mAge;
    }

    public void setmAge(int mAge) {
        this.mAge = mAge;
    }

}

package com.example.olioht;

public class User {
    private String mUser;
    private String mTheatre;

    public User(String mUser, String mTheatre, String mName, String mAge) {
        this.mUser = mUser;
        this.mTheatre = mTheatre;
        this.mName = mName;
        this.mAge = mAge;
    }

    private String mName;
    private String mAge;

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

    public String getmAge() {
        return mAge;
    }

    public void setmAge(String mAge) {
        this.mAge = mAge;
    }

}

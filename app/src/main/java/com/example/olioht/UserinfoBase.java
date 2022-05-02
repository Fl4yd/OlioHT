package com.example.olioht;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Singleton profiilitietoja varten

public class UserinfoBase implements Serializable {
    private HashMap<String, User> mUsers;
    private User currentUser;
    private UserinfoBase() {
        mUsers = new HashMap<String, User>();
    }
    public static UserinfoBase get() {
        if (mUsersBase == null) {
            mUsersBase = new UserinfoBase();
        }
        return(mUsersBase);
    }


    public void addUser(String username, int age, String name, String theatre) {
        mUsers.put(username,new User(username, theatre, name, age));
    }
    public void selectUser(String username) {
        this.currentUser = mUsers.get(username);
    }
    public User getCurrentUser () {

        return this.currentUser;
    }

    public User getUserData(String username){
        return mUsers.get(username);
    }


    private static UserinfoBase mUsersBase;

}


package com.example.olioht;

import java.util.ArrayList;
import java.util.List;

// Singleton profiilitietoja varten

public class UserinfoBase {
    private List<User> mUsers;
    private UserinfoBase() {
        mUsers = new ArrayList<>();
    }
    public void addUser(String username, String age, String name, String theatre) {
        User user = new User();
        user.setmUser(username);
        user.setmAge(age);
        user.setmName(name);
        user.setmTheatre(theatre);
        mUsers.add(user);
    }
    public User getUserData(String username){
        for (User element : mUsers) {
            if (element.getmUser().equals(username)) {
                return(element);

            }
        }
        return null;
    }

    public List<User> getUsers(){
        return(mUsers);
    }
    private static UserinfoBase mUsersBase;
    public static UserinfoBase get() {
        if (mUsersBase == null) {
            mUsersBase = new UserinfoBase();
        }
        return(mUsersBase);
    }
}


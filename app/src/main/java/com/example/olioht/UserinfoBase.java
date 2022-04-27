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
class User {
    private String mUser;
    private String mTheatre;
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

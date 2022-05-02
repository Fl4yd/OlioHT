package com.example.olioht;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

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

    public void loadData(Context context) {
        try {
            System.out.println("Working Directory = " + System.getProperty("user.dir"));
        FileInputStream fis = context.openFileInput("userinfo.set");
        ObjectInputStream ois = null;
        ois = new ObjectInputStream(fis);
        this.mUsers = (Movies) ois.readObject();
        ois.close();
        fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

}
    public void saveData(Context context) {
        try {
        FileOutputStream fos = context.openFileOutput("userinfo.ser", Context.MODE_PRIVATE);
        ObjectOutputStream ous = new ObjectOutputStream(fos);
        ous.writeObject(this.mUsers);
        fos.close();
        ous.close();
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    private static UserinfoBase mUsersBase;

}

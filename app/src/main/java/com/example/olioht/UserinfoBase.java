package com.example.olioht;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;


    //Singleton for the userdata
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


    //Loads data from internal storage
    public void loadData(Context context) {
        try {

                FileInputStream fis = context.openFileInput("userinfo.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
                this.mUsers = (HashMap) ois.readObject();
                ois.close();
                fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

}

    //Saves data on internal storage
    public void saveData(Context context) {
        try {
        FileOutputStream fos = context.openFileOutput("userinfo.txt", Context.MODE_PRIVATE);
        ObjectOutputStream ous = new ObjectOutputStream(fos);
        ous.writeObject(this.mUsers);
        fos.close();
        ous.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    private static UserinfoBase mUsersBase;

}


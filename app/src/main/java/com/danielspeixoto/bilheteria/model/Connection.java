package com.danielspeixoto.bilheteria.model;


import android.content.Context;
import android.content.SharedPreferences;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.helper.App;
import com.danielspeixoto.bilheteria.helper.DatabaseContract;
import com.danielspeixoto.bilheteria.model.pojo.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import lombok.Getter;
import rx.Single;
import rx.SingleSubscriber;

import static com.danielspeixoto.bilheteria.model.CRUD.mDatabase;

/**
 * Created by danielspeixoto on 2/14/17.
 */

public class Connection implements DatabaseContract {

    @Getter
    private static User currentUser;

    public static void logIn(User user) {
        currentUser = user;
        CRUD.updateDatabase();
        SharedPreferences.Editor editor = App.getContext().getSharedPreferences("login", Context.MODE_PRIVATE).edit();
        editor.putString(EMAIL, user.getEmail());
        editor.putString(PASSWORD, user.getPassword());
        editor.putString(ADM, user.getAdm());
        editor.putString(NAME, user.getName());
        editor.apply();
        try {
            File file = new File(App.getContext().getDir("data", App.MODE_PRIVATE), "permissions");
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
            outputStream.writeObject(user.getPermissions());
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Single<User> logIn(String email, String password) {
        return CRUDUsers.logIn(email, password);
    }

    public static boolean isLogged() {
        //TODO Get validation without consuming much time
        if (currentUser == null) {
            SharedPreferences preferences = App.getContext().getSharedPreferences("login", Context.MODE_PRIVATE);
            if (preferences.contains(EMAIL)) {
                try {
                    File file = new File(App.getContext().getDir("data", App.MODE_PRIVATE), "permissions");
                    ObjectInputStream outputStream = new ObjectInputStream(new FileInputStream(file));
                    currentUser = new User(preferences.getString(NAME, ""), preferences.getString(EMAIL, ""), preferences.getString(PASSWORD, ""), preferences.getString(ADM, ""), (HashMap<String, Boolean>) outputStream.readObject());
                    CRUD.updateDatabase();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return currentUser != null;

    }

    public static void logOff() {
        currentUser = null;
        App.getContext().getSharedPreferences("login", Context.MODE_PRIVATE).edit().clear().commit();
        CRUD.updateDatabase();
    }

    private static Single<User> updateUser() {
        return Single.create(new Single.OnSubscribe<User>() {
            @Override
            public void call(SingleSubscriber<? super User> singleSubscriber) {
                mDatabase.child(User.class.getSimpleName()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String email = currentUser.getEmail();
                        if (dataSnapshot.hasChild(email) &&
                                dataSnapshot.child(email).child(PASSWORD).getValue().equals(currentUser.getPassword())) {
                            User user = dataSnapshot.child(email).getValue(User.class);
                            Connection.logIn(user);
                        } else {
                            logOff();
                            App.showMessage("Your email or password has been changed");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        App.showMessage(App.getStringResource(R.string.error_occurred));
                    }
                });
            }
        });

    }
}

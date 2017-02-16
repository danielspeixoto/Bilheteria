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

import lombok.Getter;
import rx.Single;

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
        editor.putInt(LEVEL, user.getLevel());
        editor.apply();
    }

    public static Single<User> logIn(String email, String password) {
        return CRUDUsers.logIn(email, password);
    }

    public static boolean isLogged() {
        //TODO Get validation without consuming much time
        if (currentUser == null) {
            SharedPreferences preferences = App.getContext().getSharedPreferences("login", Context.MODE_PRIVATE);
            if (preferences.contains(EMAIL)) {
                currentUser = new User(preferences.getString(NAME, ""), preferences.getString(EMAIL, ""), preferences.getString(PASSWORD, ""), preferences.getString(ADM, ""), preferences.getInt(LEVEL, 0));
                updateUser();
                CRUD.updateDatabase();
            }
        }
        return currentUser != null;

    }

    public static void logOff() {
        currentUser = null;
        CRUD.updateDatabase();
        App.getContext().getSharedPreferences("login", Context.MODE_PRIVATE).edit().clear().apply();
    }

    private static void updateUser() {
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
}

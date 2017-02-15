package com.danielspeixoto.bilheteria.model;


import android.content.Context;
import android.content.SharedPreferences;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.helper.App;
import com.danielspeixoto.bilheteria.helper.SimpleCallback;
import com.danielspeixoto.bilheteria.model.pojo.User;

import lombok.Getter;
import rx.Single;
import rx.SingleSubscriber;
import rx.schedulers.Schedulers;

/**
 * Created by danielspeixoto on 2/14/17.
 */

public class Connection {

    @Getter
    private static User currentUser;

    public static void logIn(User user) {
        currentUser = user;
        CRUD.updateDatabase();
        SharedPreferences.Editor editor = App.getContext().getSharedPreferences("login", Context.MODE_PRIVATE).edit();
        editor.putString("email", user.getEmail());
        editor.putString("password", user.getPassword());
        editor.apply();
    }

    public static Single<User> logIn(String email, String password) {
        return CRUDUsers.logIn(email, password);
    }

    public static void isLogged(SimpleCallback callback) {
        if (currentUser == null) {
            SharedPreferences preferences = App.getContext().getSharedPreferences("login", Context.MODE_PRIVATE);
            logIn(preferences.getString("email", ""), preferences.getString("password", "")).subscribeOn(Schedulers.immediate()).subscribe(new SingleSubscriber<User>() {
                @Override
                public void onSuccess(User value) {
                    currentUser = value;
                    CRUD.updateDatabase();
                    callback.run();
                }

                @Override
                public void onError(Throwable error) {
                    App.showMessage(App.getStringResource(R.string.error_occurred));
                }
            });

        }
    }

    public static boolean isLogged() {
        return currentUser != null;
    }
}

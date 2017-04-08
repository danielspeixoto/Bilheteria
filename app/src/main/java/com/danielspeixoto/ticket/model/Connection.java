package com.danielspeixoto.ticket.model;


import android.content.Context;
import android.content.SharedPreferences;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.helper.DatabaseContract;
import com.danielspeixoto.ticket.model.pojo.User;
import com.danielspeixoto.ticket.util.Structure;

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

/**
 * Created by danielspeixoto on 2/14/17.
 */

public class Connection implements DatabaseContract {

    @Getter
    private static User currentUser;

    public static void logIn(User user) {
        currentUser = Structure.User(user);
        CRUD.updateDatabase();
        new Thread(() -> {
            SharedPreferences.Editor editor = App.getContext()
		            .getSharedPreferences("login", Context.MODE_PRIVATE).edit();
            editor.putString(EMAIL, user.getUsername());
            editor.putString(PASSWORD, user.getPassword());
            editor.putString(ADM, user.getAdm());
            editor.putString(NAME, user.getName());
            editor.apply();
            try {
                File file = new File(App.getContext()
		                .getDir("data", App.MODE_PRIVATE), "permissions");
                ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
                outputStream.writeObject(user.getPermissions());
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).run();
    }

    public static Single<User> findUser(String email, String password) {
        return CRUDUsers.logIn(email, password);
    }

    public static boolean hasAccountSavedOnDevice() {
        //TODO Get validation without consuming much time
        if (!isLogged()) {
            SharedPreferences preferences = App.getContext()
		            .getSharedPreferences("login", Context.MODE_PRIVATE);
            if (preferences.contains(EMAIL)) {
                try {
                    File file = new File(App.getContext()
		                    .getDir("data", App.MODE_PRIVATE), "permissions");
                    ObjectInputStream outputStream = new ObjectInputStream(new FileInputStream(file));
                    currentUser = Structure.User(new User(preferences.getString(NAME, ""),
		                    preferences.getString(EMAIL, ""),
		                    preferences.getString(PASSWORD, ""),
		                    preferences.getString(ADM, ""),
		                    (HashMap<String, Boolean>) outputStream.readObject()));
                    CRUD.updateDatabase();
                    updateUser();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return isLogged();
    }

    public static boolean isLogged() {
        return currentUser != null;
    }

    public static void logOff() {
        currentUser = null;
        App.getContext().getSharedPreferences("login", Context.MODE_PRIVATE).edit().clear().commit();
        CRUD.updateDatabase();
    }

    private static void updateUser() {
        // Sync data with database
	    currentUser = Structure.User(currentUser);
	    CRUDUsers.update(currentUser).subscribe(new SingleSubscriber<User>() {
		    @Override
		    public void onSuccess(User value) {
				Connection.logIn(value);
		    }
		
		    @Override
		    public void onError(Throwable error) {
			    logOff();
			    App.showMessage(App.getStringResource(R.string.error_occurred));
		    }
	    });
    }
}

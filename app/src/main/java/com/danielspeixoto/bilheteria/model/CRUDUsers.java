package com.danielspeixoto.bilheteria.model;

import com.danielspeixoto.bilheteria.model.pojo.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import rx.Single;

/**
 * Created by danielspeixoto on 2/14/17.
 */

public class CRUDUsers extends CRUD {

    public static Single<User> createAdm(User user) {
        return Single.create(singleSubscriber -> {
            mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    String email = user.getEmail();
                    // TODO Checar se realmente funciona
                    if (!snapshot.hasChild(email)) {
                        user.setLevel(ADM);
                        user.setAdm(email);
                        mDatabase.child(email).setValue(user);
                        singleSubscriber.onSuccess(user);
                    }
                    singleSubscriber.onError(new Throwable("User already exists"));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    singleSubscriber.onError(new Throwable("An error occurred"));
                }
            });
        });
    }
}

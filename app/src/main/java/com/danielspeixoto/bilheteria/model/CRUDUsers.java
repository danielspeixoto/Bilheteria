package com.danielspeixoto.bilheteria.model;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.helper.App;
import com.danielspeixoto.bilheteria.helper.Permissions;
import com.danielspeixoto.bilheteria.model.pojo.User;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import rx.Observable;
import rx.Single;

/**
 * Created by danielspeixoto on 2/14/17.
 */

public class CRUDUsers extends CRUD {

    public static Single<User> logIn(String email, String password) {
        return Single.create(subscriber -> mDatabase.child(User.class.getSimpleName()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild(email) &&
                        dataSnapshot.child(email).child(PASSWORD).getValue().equals(password)) {
                    User user = dataSnapshot.child(email).getValue(User.class);
                    subscriber.onSuccess(user);
                    Connection.logIn(user);
                } else {
                    subscriber.onError(new Throwable("Incorrect email or password"));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                subscriber.onError(new Throwable(App.getStringResource(R.string.error_occurred)));
            }
        }));
    }

    public static Single<User> createAdm(User user) {
        return Single.create(singleSubscriber -> mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String email = user.getEmail();
                // Verifica se ja existe algum usuario com este email
                if (!snapshot.hasChild(email)) {
                    user.setPermissions(Permissions.getADMPermissions());
                    user.setAdm(email);
                    mDatabase.child(User.class.getSimpleName()).child(email).setValue(user);
                    singleSubscriber.onSuccess(user);
                }
                singleSubscriber.onError(new Throwable("User already exists"));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                singleSubscriber.onError(new Throwable(App.getStringResource(R.string.error_occurred)));
            }
        }));
    }

    public static Single<User> createUser(User user) {
        String adm = Connection.getCurrentUser().getAdm();
        user.setAdm(adm);
        String email = user.getEmail();
        return Single.create(singleSubscriber -> {
            // Users general node
            tempDatabase = mDatabase.getParent().child(User.class.getSimpleName());
            tempDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    // Verifica se ja existe algum usuario com este email
                    if (!snapshot.hasChild(email)) {
                        mDatabase.getParent().child(User.class.getSimpleName()).child(email).setValue(user);
                        singleSubscriber.onSuccess(user);

                    }
                    singleSubscriber.onError(new Throwable("User already exists"));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    singleSubscriber.onError(new Throwable(App.getStringResource(R.string.error_occurred)));
                }
            });
            // Users inside an adm node
            tempDatabase = mDatabase.child(adm).child(User.class.getSimpleName());
            tempDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    // Verifica se ja existe algum usuario com este email
                    if (!snapshot.hasChild(email)) {
                        mDatabase.child(User.class.getSimpleName()).child(email).setValue(user);
                        singleSubscriber.onSuccess(user);
                    }
                    singleSubscriber.onError(new Throwable("User already exists"));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    singleSubscriber.onError(new Throwable(App.getStringResource(R.string.error_occurred)));
                }
            });
        });
    }

    public static Observable<User> getAll() {
        tempDatabase = mDatabase.child(User.class.getSimpleName());
        return Observable.create(subscriber -> tempDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                subscriber.onNext(dataSnapshot.getValue(User.class));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                subscriber.onError(new Throwable(App.getStringResource(R.string.error_occurred)));
            }
        }));
    }
}

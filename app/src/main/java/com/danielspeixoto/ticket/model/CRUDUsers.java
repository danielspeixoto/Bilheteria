package com.danielspeixoto.ticket.model;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.helper.Permissions;
import com.danielspeixoto.ticket.model.pojo.User;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import rx.Observable;
import rx.Single;

/**
 * Created by danielspeixoto on 2/14/17.
 */

public class CRUDUsers extends CRUD {

    public static Single<User> logIn(String email, String password) {
        return Single.create(subscriber -> rootDatabase.child(User.class.getSimpleName()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild(email) &&
                        dataSnapshot.child(email).child(PASSWORD).getValue().equals(password)) {
                    User user = dataSnapshot.child(email).getValue(User.class);
                    subscriber.onSuccess(user);
                    Connection.logIn(user);
                } else {
                    subscriber.onError(new Throwable(App.getStringResource(R.string.incorrect_username_password)));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                subscriber.onError(new Throwable(App.getStringResource(R.string.error_occurred)));
            }
        }));
    }

    public static Single<User> createAdm(User user) {
        return Single.create(singleSubscriber -> rootDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String email = user.getUsername();
                // Verifica se ja existe algum usuario com este username
                if (!snapshot.hasChild(email)) {
                    user.setPermissions(Permissions.getADMPermissions());
                    user.setAdm(email);
                    rootDatabase.child(User.class.getSimpleName()).child(email).setValue(user);
                    singleSubscriber.onSuccess(user);
                }
                singleSubscriber.onError(new Throwable(App.getStringResource(R.string.username_already_exists)));
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
        String email = user.getUsername();
        return Single.create(singleSubscriber -> {
            // Users general node
            DatabaseReference tempDatabase = mDatabase.getParent().child(User.class.getSimpleName());
            tempDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    // Verifica se ja existe algum usuario com este username
                    if (!snapshot.hasChild(email)) {
                        mDatabase.getParent().child(User.class.getSimpleName()).child(email).setValue(user);
                        singleSubscriber.onSuccess(user);

                    }
                    singleSubscriber.onError(new Throwable(App.getStringResource(R.string.username_already_exists)));
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
                    // Verifica se ja existe algum usuario com este username
                    if (!snapshot.hasChild(email)) {
                        mDatabase.child(User.class.getSimpleName()).child(email).setValue(user);
                        singleSubscriber.onSuccess(user);
                    }
                    singleSubscriber.onError(new Throwable(App.getStringResource(R.string.username_already_exists)));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    singleSubscriber.onError(new Throwable(App.getStringResource(R.string.error_occurred)));
                }
            });
        });
    }

    public static Observable<User> getAll() {
        DatabaseReference tempDatabase = mDatabase.child(User.class.getSimpleName());
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
    
    public static Single<User> update(User user) {
        DatabaseReference tempDatabase = rootDatabase;
    	if(!user.getAdm().equals(user.getUsername())) {
    		tempDatabase = tempDatabase.child(user.getAdm());
	    }
	    tempDatabase = rootDatabase.child(User.class.getSimpleName());
        final DatabaseReference tempFinalDatabase = tempDatabase;
	    return Single.create(singleSubscriber -> tempFinalDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String email = user.getUsername();
	            if (snapshot.hasChild(email) &&
	                    snapshot.child(email).child(PASSWORD)
			            .getValue().equals(user.getPassword())) {
	            	
		            tempFinalDatabase.child(email).setValue(user);
		            singleSubscriber.onSuccess(user);
	            } else {
		            App.showMessage("Your username or password has been changed");
	            }
            }
        
            @Override
            public void onCancelled(DatabaseError databaseError) {
                singleSubscriber.onError(new Throwable(App.getStringResource(R.string.error_occurred)));
            }
        }));
    }
}

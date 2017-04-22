package com.danielspeixoto.ticket.model;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.model.pojo.Offer;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import rx.Observable;

/**
 * Created by danielspeixoto on 2/14/17.
 */

public class CRUDOffers extends CRUD {

    public static void insert(Offer offer) {
        DatabaseReference tempDatabase = mDatabase.child(Offer.class.getSimpleName());
        offer.setUid(tempDatabase.push().getKey());
        tempDatabase.child(offer.getUid()).setValue(offer);
    }

    public static void update(Offer offer) {
        mDatabase.child(Offer.class.getSimpleName()).child(offer.getUid()).setValue(offer);
    }

    public static void delete(String uid) {
        mDatabase.child(Offer.class.getSimpleName()).child(uid).removeValue();
    }

    public static Observable<Offer> getAll() {
        DatabaseReference tempDatabase = mDatabase.child(Offer.class.getSimpleName());
        return Observable.create(subscriber -> tempDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                subscriber.onNext(dataSnapshot.getValue(Offer.class));
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

    public static Observable<Offer> getActivated() {
        DatabaseReference tempDatabase = mDatabase.child(Offer.class.getSimpleName());
        return Observable.create(subscriber -> tempDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if ((boolean) dataSnapshot.child(Offer.IS_ACTIVATED).getValue()) {
                    subscriber.onNext(dataSnapshot.getValue(Offer.class));
                }
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


    public static void toggleActivated(String UID, boolean activated) {
        mDatabase.child(Offer.class.getSimpleName()).child(UID).child(Offer.IS_ACTIVATED).setValue(activated);
    }
}

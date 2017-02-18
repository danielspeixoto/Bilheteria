package com.danielspeixoto.bilheteria.model;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.helper.App;
import com.danielspeixoto.bilheteria.model.pojo.Offer;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import rx.Observable;

/**
 * Created by danielspeixoto on 2/14/17.
 */

public class CRUDOffers extends CRUD {

    public static void insertOffer(Offer offer) {
        tempDatabase = mDatabase.child(Offer.class.getSimpleName());
        offer.setUid(tempDatabase.push().getKey());
        tempDatabase.child(offer.getUid()).setValue(offer);
    }

    public static Observable<Offer> getAll() {
        tempDatabase = mDatabase.child(Offer.class.getSimpleName());
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
}

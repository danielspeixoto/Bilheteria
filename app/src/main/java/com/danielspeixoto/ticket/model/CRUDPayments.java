package com.danielspeixoto.ticket.model;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.model.pojo.Payment;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import rx.Observable;
import rx.Single;

/**
 * Created by danielspeixoto on 2/15/17.
 */

public class CRUDPayments extends CRUD {

    public static Observable<Payment> getAll() {
        DatabaseReference tempDatabase = mDatabase.child(Payment.class.getSimpleName());
        return Observable.create(subscriber -> tempDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                subscriber.onNext(dataSnapshot.getValue(Payment.class));
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

    public static Single<Boolean> insert(Payment payment) {
        return Single.create(subscriber -> {
            if(isConnected) {
                DatabaseReference tempDatabase = mDatabase.child(Payment.class.getSimpleName());
                payment.setUid(tempDatabase.push().getKey());
                tempDatabase.child(payment.getUid()).setValue(payment);
                subscriber.onSuccess(true);
            } else {
                subscriber.onSuccess(false);
            }
        });

    }
    
    public static Single<Boolean> delete(String uid) {
        return Single.create(subscriber -> {
            if(isConnected) {
                mDatabase.child(Payment.class.getSimpleName()).child(uid).removeValue();
                subscriber.onSuccess(true);
            } else {
                subscriber.onSuccess(false);
            }
        });
    }
    
}

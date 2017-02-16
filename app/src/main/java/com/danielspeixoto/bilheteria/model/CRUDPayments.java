package com.danielspeixoto.bilheteria.model;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.helper.App;
import com.danielspeixoto.bilheteria.model.pojo.PaymentInfo;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import rx.Observable;

/**
 * Created by danielspeixoto on 2/15/17.
 */

public class CRUDPayments extends CRUD {

    public static Observable<PaymentInfo> getAll() {
        tempDatabase = mDatabase.child(PaymentInfo.class.getSimpleName());
        return Observable.create(subscriber -> tempDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                subscriber.onNext(dataSnapshot.getValue(PaymentInfo.class));
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

    public static void insertPayment(PaymentInfo payment) {
        tempDatabase = mDatabase.child(PaymentInfo.class.getSimpleName());
        payment.setUid(tempDatabase.push().getKey());
        tempDatabase.child(payment.getUid()).setValue(payment);
    }
}

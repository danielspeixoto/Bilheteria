package com.danielspeixoto.bilheteria.model;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.helper.App;
import com.danielspeixoto.bilheteria.helper.Time;
import com.danielspeixoto.bilheteria.model.pojo.Ticket;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import rx.Observable;

/**
 * Created by danielspeixoto on 2/18/17.
 */

public class CRUDTickets extends CRUD {

    public static void insertTicket(Ticket ticket) {
        tempDatabase = mDatabase.child(Ticket.class.getSimpleName()).child(String.valueOf(Time.getTodayInMillis()));
        ticket.setUid(tempDatabase.push().getKey());
        tempDatabase.child(ticket.getUid()).setValue(ticket, (databaseError, databaseReference) -> {
            //TODO
//            if(databaseError == null) {
//
//            } else {
//
//            }
        });
    }

    public static Observable<Ticket> getInPeriod(long start, long end) {
        tempDatabase = mDatabase.child(Ticket.class.getSimpleName());
        return Observable.create(subscriber -> tempDatabase.orderByKey().startAt(String.valueOf(start)).endAt(String.valueOf(end)).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                dataSnapshot.getRef().addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        subscriber.onNext(dataSnapshot.getValue(Ticket.class));
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

                    }
                });
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

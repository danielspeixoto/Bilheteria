package com.danielspeixoto.ticket.model;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.helper.Time;
import com.danielspeixoto.ticket.model.pojo.Ticket;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import rx.Observable;

/**
 * Created by danielspeixoto on 2/18/17.
 */

public class CRUDTickets extends CRUD {

    public static void insert(Ticket ticket) {
        DatabaseReference tempDatabase = mDatabase.child(Ticket.class.getSimpleName()).child(String.valueOf(Time.getTodayInMillis()));
        ticket.setUid(tempDatabase.push().getKey());
        tempDatabase.child(ticket.getUid()).setValue(ticket);
    }

    public static void update(Ticket ticket) {
        mDatabase.child(Ticket.class.getSimpleName())
                .child(String.valueOf(Time.getDayInMillis(ticket.getTimestamp())))
                .child(ticket.getUid()).setValue(ticket);
    }

    public static Observable<Ticket> getInPeriod(long start, long end) {
        DatabaseReference tempDatabase = mDatabase.child(Ticket.class.getSimpleName());
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

    //TODO Use elastic search
    public static Observable<Ticket> search(String query) {
        DatabaseReference tempDatabase = mDatabase.child(Ticket.class.getSimpleName());
        return Observable.create(subscriber -> tempDatabase.orderByValue().startAt(query).endAt(query).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

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
    
    public static void delete(String uid) {
        mDatabase.child(Ticket.class.getSimpleName()).child(uid).removeValue();
    }

}

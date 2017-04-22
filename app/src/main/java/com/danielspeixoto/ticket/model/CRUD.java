package com.danielspeixoto.ticket.model;

import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.helper.DatabaseContract;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by danielspeixoto on 2/14/17.
 */

public class CRUD implements DatabaseContract {

    protected static final DatabaseReference rootDatabase;
    protected static DatabaseReference mDatabase;
    protected static boolean isConnected = false;

    static {
        rootDatabase = FirebaseDatabase.getInstance().getReference();
        rootDatabase.child(".info/connected").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                isConnected = snapshot.getValue(Boolean.class);
                App.log(String.valueOf(isConnected));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                isConnected = false;
            }
        });
        mDatabase = rootDatabase;
    }

    public static void updateDatabase() {
        if (Connection.isLogged()) {
            mDatabase = rootDatabase.child(Connection.getCurrentUser().getAdm());
        } else {
            mDatabase = rootDatabase;
        }
    }

}

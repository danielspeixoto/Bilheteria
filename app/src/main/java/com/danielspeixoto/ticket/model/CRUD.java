package com.danielspeixoto.ticket.model;

import com.danielspeixoto.ticket.helper.DatabaseContract;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by danielspeixoto on 2/14/17.
 */

public class CRUD implements DatabaseContract {

    protected static DatabaseReference mDatabase, tempDatabase;
    protected static final DatabaseReference rootDatabase;

    static {
        rootDatabase = FirebaseDatabase.getInstance().getReference();
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

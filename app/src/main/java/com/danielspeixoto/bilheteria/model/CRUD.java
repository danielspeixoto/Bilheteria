package com.danielspeixoto.bilheteria.model;

import com.danielspeixoto.bilheteria.helper.DatabaseContract;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by danielspeixoto on 2/14/17.
 */

public class CRUD implements DatabaseContract {

    protected static DatabaseReference mDatabase, tempDatabase;

    static {
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public static void updateDatabase() {
        mDatabase = FirebaseDatabase.getInstance().getReference().child(Connection.getCurrentUser().getAdm());
    }

}

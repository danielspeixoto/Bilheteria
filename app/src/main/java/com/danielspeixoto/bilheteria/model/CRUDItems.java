package com.danielspeixoto.bilheteria.model;

import com.danielspeixoto.bilheteria.model.pojo.ItemInfo;

/**
 * Created by danielspeixoto on 2/14/17.
 */

public class CRUDItems extends CRUD {

    public static void insertItem(ItemInfo item) {
        tempDatabase = mDatabase.child(ItemInfo.class.getSimpleName());
        item.setUid(tempDatabase.push().getKey());
        tempDatabase.child(item.getUid()).setValue(item);
    }
}

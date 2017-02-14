package com.danielspeixoto.bilheteria.model;

import lombok.Data;

/**
 * Created by danielspeixoto on 2/14/17.
 */
@Data
public class ItemInfo {

    protected String uid, name;
    protected float price;

    public ItemInfo(String uid, String name, float price) {
        this.uid = uid;
        this.name = name;
        this.price = price;
    }
}

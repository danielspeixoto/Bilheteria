package com.danielspeixoto.bilheteria.model;

import lombok.Data;

/**
 * Created by danielspeixoto on 2/14/17.
 */

@Data
public class Item extends ItemInfo {

    private int amount = 0;

    public Item(String uid, String name, float price, int amount) {
        super(uid, name, price);
        this.amount = amount;
    }
}

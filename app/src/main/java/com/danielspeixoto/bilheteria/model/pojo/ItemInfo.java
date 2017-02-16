package com.danielspeixoto.bilheteria.model.pojo;

import lombok.Data;

/**
 * Created by danielspeixoto on 2/14/17.
 */
@Data
public class ItemInfo {

    protected String uid, name;
    protected float price;

    public ItemInfo() {
    }

    public ItemInfo(String uid, String name, float price) {
        this.uid = uid;
        this.name = name;
        this.price = price;
    }

    public ItemInfo(String name, float price) {
        this.name = name;
        this.price = price;
    }
}

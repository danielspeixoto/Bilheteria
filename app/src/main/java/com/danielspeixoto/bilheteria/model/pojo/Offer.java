package com.danielspeixoto.bilheteria.model.pojo;

import lombok.Data;

/**
 * Created by danielspeixoto on 2/14/17.
 */

@Data
public class Offer {

    public static final String IS_ACTIVATED = "activated";

    private String uid, name;
    private float price;
    private int amount = 0;
    private boolean isActivated = true;

    public Offer() {

    }

    public Offer(String name, float price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public Offer(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public void changeAmount(int variation) {
        amount += variation;
    }

    public void toggleActivated() {
        isActivated = !isActivated;
    }
}

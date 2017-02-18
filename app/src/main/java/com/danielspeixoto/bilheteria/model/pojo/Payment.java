package com.danielspeixoto.bilheteria.model.pojo;

import lombok.Data;

/**
 * Created by danielspeixoto on 2/14/17.
 */

@Data
public class Payment {

    private String uid, name;
    private String observations;
    private float amount;

    public Payment() {

    }

    public Payment(String name) {
        this.name = name;
    }

    public Payment(String name, String observations, float amount) {
        this.name = name;
        this.observations = observations;
        this.amount = amount;
    }
}

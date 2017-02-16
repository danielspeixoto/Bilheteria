package com.danielspeixoto.bilheteria.model.pojo;

import lombok.Data;

/**
 * Created by danielspeixoto on 2/14/17.
 */

@Data
public class Payment extends PaymentInfo {
    private String observations;
    private float amount;

    public Payment(String name) {
        super(name);
    }
}

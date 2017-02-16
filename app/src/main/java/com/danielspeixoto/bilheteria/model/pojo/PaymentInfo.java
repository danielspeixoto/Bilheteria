package com.danielspeixoto.bilheteria.model.pojo;

import lombok.Data;

/**
 * Created by danielspeixoto on 2/14/17.
 */

@Data
public class PaymentInfo {

    protected String uid, name;

    public PaymentInfo(String name) {
        this.name = name;
    }

    public PaymentInfo() {
    }
}

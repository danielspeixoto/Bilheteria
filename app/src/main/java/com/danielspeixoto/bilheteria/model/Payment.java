package com.danielspeixoto.bilheteria.model;

import lombok.Data;

/**
 * Created by danielspeixoto on 2/14/17.
 */

@Data
public class Payment extends PaymentInfo {
    String observations;
    float amount;
}

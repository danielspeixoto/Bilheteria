package com.danielspeixoto.bilheteria.util;

import com.danielspeixoto.bilheteria.model.pojo.Offer;
import com.danielspeixoto.bilheteria.model.pojo.Payment;

/**
 * Created by danielspeixoto on 2/14/17.
 */

public class Validate {

    public static final String OK = "OK";
    private static String message;

    public static String Offer(Offer offer) {
        message = OK;
        if (offer.getName().length() == 0) {
            message = "Must have a name";
        } else if (offer.getPrice() < 0.0) {
            message = "Cannot have a negative value";
        }
        return message;
    }

    public static String Payment(Payment payment) {
        message = OK;
        if (payment.getName().length() == 0) {
            message = "Must have a name";
        }
        return message;
    }
}

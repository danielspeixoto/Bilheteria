package com.danielspeixoto.bilheteria.util;

import com.danielspeixoto.bilheteria.model.pojo.ItemInfo;
import com.danielspeixoto.bilheteria.model.pojo.PaymentInfo;

/**
 * Created by danielspeixoto on 2/14/17.
 */

public class Validate {

    public static final String OK = "OK";
    private static String message;

    public static String Item(ItemInfo item) {
        message = OK;
        if (item.getName().length() == 0) {
            message = "Must have a name";
        } else if (item.getPrice() < 0.0) {
            message = "Cannot have a negative value";
        }
        return message;
    }

    public static String Payment(PaymentInfo payment) {
        message = OK;
        if (payment.getName().length() == 0) {
            message = "Must have a name";
        }
        return message;
    }
}

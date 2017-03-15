package com.danielspeixoto.ticket.util;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.model.pojo.Offer;
import com.danielspeixoto.ticket.model.pojo.Payment;

/**
 * Created by danielspeixoto on 2/14/17.
 */

public class Validate {

    public static final String OK = "OK";
    private static String message;

    public static String Offer(Offer offer) {
        message = OK;
        if (offer.getName().length() == 0) {
            message = App.getStringResource(R.string.name_must_fill);
        }
        return message;
    }

    public static String Payment(Payment payment) {
        message = OK;
        if (payment.getName().length() == 0) {
            message = App.getStringResource(R.string.name_must_fill);
        }
        return message;
    }
}

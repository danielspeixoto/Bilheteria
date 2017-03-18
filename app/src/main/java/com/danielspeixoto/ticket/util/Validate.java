package com.danielspeixoto.ticket.util;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.model.pojo.Offer;
import com.danielspeixoto.ticket.model.pojo.Payment;
import com.danielspeixoto.ticket.model.pojo.User;

/**
 * Created by danielspeixoto on 2/14/17.
 */

public class Validate {

    public static final String OK = "OK";
    private static String message;

    public static String User(User user) {
        message = OK;
        if (user.getUsername().length() == 0) {
            message = App.getStringResource(R.string.username_must_fill);
        } else if (!user.getUsername().matches("[a-zA-Z0-9]+")) {
            message = App.getStringResource(R.string.username_letters_numbers);
        }
        return message;
    }

    public static String Offer(Offer offer) {
        message = OK;
        offer.setName(offer.getName().trim());
        if (offer.getName().length() == 0) {
            message = App.getStringResource(R.string.name_must_fill);
        }
        return message;
    }

    public static String Payment(Payment payment) {
        message = OK;
        payment.setName(payment.getName().trim());
        if (payment.getName().length() == 0) {
            message = App.getStringResource(R.string.name_must_fill);
        }
        return message;
    }
}

package com.danielspeixoto.ticket.module;

import com.danielspeixoto.ticket.model.pojo.Payment;

/**
 * Created by danielspeixoto on 2/15/17.
 */

public class InsertPayment {

    public interface View extends ActivityBase.View {
        void clear();
    }

    public interface Presenter extends ActivityBase.Presenter {
        void insert(Payment payment);
    }
}

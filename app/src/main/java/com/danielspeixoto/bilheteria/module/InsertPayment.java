package com.danielspeixoto.bilheteria.module;

import com.danielspeixoto.bilheteria.model.pojo.PaymentInfo;

/**
 * Created by danielspeixoto on 2/15/17.
 */

public class InsertPayment {

    public interface View extends ActivityBase.View {
        void clear();
    }

    public interface Presenter extends ActivityBase.Presenter {
        void insert(PaymentInfo payment);
    }
}

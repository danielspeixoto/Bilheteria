package com.danielspeixoto.bilheteria.view.recycler.adapter;

import android.view.ViewGroup;

import com.danielspeixoto.bilheteria.model.pojo.Payment;
import com.danielspeixoto.bilheteria.module.Source;
import com.danielspeixoto.bilheteria.view.activity.BaseActivity;
import com.danielspeixoto.bilheteria.view.recycler.holder.PaymentHolder;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by danielspeixoto on 2/15/17.
 */

public abstract class PaymentsAdapter<S extends PaymentHolder<? extends PaymentsAdapter>>
        extends SourceAdapter<Payment, S, Source.Presenter> {

    public PaymentsAdapter(BaseActivity activity) {
        super(activity);
    }

    public abstract S onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public void reset() {
        for (Payment payment : data) {
            payment.setAmount(0);
        }
    }

    public List<Payment> getNotZero() {
        List<Payment> list = new ArrayList<Payment>();
        for (Payment payment : data) {
            if (payment.getAmount() != 0) {
                list.add(payment);
            }
        }
        return list;
    }
}

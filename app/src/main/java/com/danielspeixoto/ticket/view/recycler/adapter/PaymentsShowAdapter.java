package com.danielspeixoto.ticket.view.recycler.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.view.activity.BaseActivity;
import com.danielspeixoto.ticket.view.recycler.holder.PaymentHolder;

/**
 * Created by danielspeixoto on 2/18/17.
 */

public class PaymentsShowAdapter extends PaymentsAdapter<PaymentHolder<PaymentsShowAdapter>> {

    public PaymentsShowAdapter(BaseActivity activity) {
        super(activity);
    }

    @Override
    public PaymentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PaymentHolder<>(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_payments, parent, false), this);
    }
}

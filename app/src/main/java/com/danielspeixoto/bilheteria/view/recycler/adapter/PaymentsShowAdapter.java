package com.danielspeixoto.bilheteria.view.recycler.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.view.activity.BaseActivity;
import com.danielspeixoto.bilheteria.view.recycler.holder.PaymentHolder;

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

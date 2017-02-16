package com.danielspeixoto.bilheteria.view.recycler.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.model.pojo.PaymentInfo;
import com.danielspeixoto.bilheteria.view.activity.BaseActivity;
import com.danielspeixoto.bilheteria.view.recycler.holder.PaymentHolder;


/**
 * Created by danielspeixoto on 2/15/17.
 */

public class PaymentsRecyclerAdapter extends SourceRecyclerAdapter<PaymentInfo> {

    public PaymentsRecyclerAdapter(BaseActivity activity) {
        super(activity);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PaymentHolder paymentHolder = (PaymentHolder) holder;
        PaymentInfo payment = data.get(position);
        paymentHolder.setId(payment.getUid());
        paymentHolder.getNameText().setText(payment.getName());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PaymentHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_payments, parent, false), this);
    }
}

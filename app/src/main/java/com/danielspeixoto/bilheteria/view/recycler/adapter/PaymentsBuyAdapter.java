package com.danielspeixoto.bilheteria.view.recycler.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.helper.SimpleCallback;
import com.danielspeixoto.bilheteria.module.OnItemChanged;
import com.danielspeixoto.bilheteria.view.activity.BaseActivity;
import com.danielspeixoto.bilheteria.view.recycler.holder.PaymentBuyHolder;

import java.util.ArrayList;

/**
 * Created by danielspeixoto on 2/18/17.
 */

public class PaymentsBuyAdapter extends PaymentsAdapter<PaymentBuyHolder> implements OnItemChanged<Float> {

    private OnItemChanged<Float> mOnItemChanged;
    private ArrayList<SimpleCallback> mSimpleCallbacks = new ArrayList<>();

    public PaymentsBuyAdapter(BaseActivity activity, OnItemChanged<Float> OnItemChanged) {
        super(activity);
        mOnItemChanged = OnItemChanged;
    }

    @Override
    public PaymentBuyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PaymentBuyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_payment_buy, parent, false), this);
    }

    @Override
    public void reset() {
        super.reset();
        for (SimpleCallback c : mSimpleCallbacks) {
            c.run();
        }
    }

    public void addCallback(SimpleCallback callback) {
        mSimpleCallbacks.add(callback);
    }

    @Override
    public void onItemChanged(Float valueChanged) {
        mOnItemChanged.onItemChanged(valueChanged);
    }
}

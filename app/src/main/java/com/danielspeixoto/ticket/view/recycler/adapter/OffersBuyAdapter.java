package com.danielspeixoto.ticket.view.recycler.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.SimpleCallback;
import com.danielspeixoto.ticket.module.OnItemChanged;
import com.danielspeixoto.ticket.view.activity.BaseActivity;
import com.danielspeixoto.ticket.view.recycler.holder.OfferBuyHolder;

import java.util.ArrayList;

/**
 * Created by danielspeixoto on 2/16/17.
 */

public class OffersBuyAdapter extends OffersAdapter<OfferBuyHolder> implements OnItemChanged<Float> {

    private OnItemChanged<Float> mOnItemChanged;
    private ArrayList<SimpleCallback> mSimpleCallbacks = new ArrayList<>();

    public OffersBuyAdapter(BaseActivity activity, OnItemChanged<Float> OnItemChanged) {
        super(activity);
        mOnItemChanged = OnItemChanged;
    }

    @Override
    public OfferBuyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new OfferBuyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_offer_buy, parent, false), this);
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

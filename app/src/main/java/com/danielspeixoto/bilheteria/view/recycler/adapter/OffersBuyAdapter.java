package com.danielspeixoto.bilheteria.view.recycler.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.helper.SimpleCallback;
import com.danielspeixoto.bilheteria.module.onItemChanged;
import com.danielspeixoto.bilheteria.view.activity.BaseActivity;
import com.danielspeixoto.bilheteria.view.recycler.holder.OfferBuyHolder;

import java.util.ArrayList;

/**
 * Created by danielspeixoto on 2/16/17.
 */

public class OffersBuyAdapter extends OffersAdapter<OfferBuyHolder> implements onItemChanged<Float> {

    private onItemChanged<Float> mOnItemChanged;
    private ArrayList<SimpleCallback> mSimpleCallbacks = new ArrayList<>();

    public OffersBuyAdapter(BaseActivity activity, onItemChanged<Float> onItemChanged) {
        super(activity);
        mOnItemChanged = onItemChanged;
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

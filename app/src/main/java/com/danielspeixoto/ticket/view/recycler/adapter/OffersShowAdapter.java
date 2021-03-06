package com.danielspeixoto.ticket.view.recycler.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.view.activity.BaseActivity;
import com.danielspeixoto.ticket.view.recycler.holder.OfferShowHolder;

/**
 * Created by danielspeixoto on 2/18/17.
 */

public class OffersShowAdapter extends OffersAdapter<OfferShowHolder> {

    public OffersShowAdapter(BaseActivity activity) {
        super(activity);
    }

    @Override
    public OfferShowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new OfferShowHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_offer_info, parent, false), this);
    }

}

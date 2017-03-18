package com.danielspeixoto.ticket.view.recycler.adapter;

import android.view.ViewGroup;

import com.danielspeixoto.ticket.model.pojo.Offer;
import com.danielspeixoto.ticket.module.Source;
import com.danielspeixoto.ticket.view.activity.BaseActivity;
import com.danielspeixoto.ticket.view.recycler.holder.OfferHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danielspeixoto on 2/16/17.
 */

public abstract class OffersAdapter<S extends OfferHolder<? extends OffersAdapter>>
        extends SourceAdapter<Offer, S, Source.Presenter> {

    public OffersAdapter(BaseActivity activity) {
        super(activity);
    }

    @Override
    public abstract S onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public void reset() {
        for (Offer offer : data) {
            offer.setAmount(0);
        }
    }

    public List<Offer> getNotZero() {
        List<Offer> list = new ArrayList<Offer>();
        for (Offer offer : data) {
            if (offer.getAmount() != 0) {
                list.add(offer);
            }
        }
        return list;
    }
}
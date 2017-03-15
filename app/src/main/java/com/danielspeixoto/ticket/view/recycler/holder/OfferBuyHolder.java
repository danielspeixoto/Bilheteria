package com.danielspeixoto.ticket.view.recycler.holder;

import android.view.View;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.view.custom.PickAmount;
import com.danielspeixoto.ticket.view.recycler.adapter.OffersBuyAdapter;

import butterknife.BindView;

/**
 * Created by danielspeixoto on 2/16/17.
 */

public class OfferBuyHolder extends OfferHolder<OffersBuyAdapter> {

    public static int amount;
    @BindView(R.id.amountPicker)
    PickAmount amountPicker;

    public OfferBuyHolder(View itemView, OffersBuyAdapter mAdapter) {
        super(itemView, mAdapter);
        amountPicker.syncAmount(() -> {
            amount = amountPicker.getAmount();
            mAdapter.onItemChanged((amount - mItem.getAmount()) * mItem.getPrice());
            mItem.setAmount(amount);
        });
        mAdapter.addCallback(() -> amountPicker.reset());
    }


}

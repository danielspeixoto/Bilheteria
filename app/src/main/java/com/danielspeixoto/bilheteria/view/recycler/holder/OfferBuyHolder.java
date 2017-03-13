package com.danielspeixoto.bilheteria.view.recycler.holder;

import android.view.View;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.view.custom.PickAmount;
import com.danielspeixoto.bilheteria.view.recycler.adapter.OffersBuyAdapter;

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

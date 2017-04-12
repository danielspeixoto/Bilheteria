package com.danielspeixoto.ticket.view.recycler.holder;

import android.view.View;
import android.widget.TextView;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.model.pojo.Offer;
import com.danielspeixoto.ticket.view.recycler.adapter.OffersAdapter;

import butterknife.BindView;

/**
 * Created by danielspeixoto on 2/16/17.
 */

public class OfferHolder<T extends OffersAdapter> extends BaseHolder<T, Offer> {

    @BindView(R.id.nameText)
    TextView nameText;
    @BindView(R.id.priceText)
    TextView priceText;

    public OfferHolder(View itemView, T mAdapter) {
        super(itemView, mAdapter);
    }

    @Override
    public void onPostCreated() {
        nameText.setText(mItem.getName());
        priceText.setText("$" + mItem.getPrice());
    }
}

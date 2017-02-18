package com.danielspeixoto.bilheteria.view.recycler.holder;

import android.view.View;
import android.widget.TextView;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.model.pojo.Offer;
import com.danielspeixoto.bilheteria.view.recycler.adapter.OffersAdapter;

import butterknife.BindView;
import lombok.Getter;

/**
 * Created by danielspeixoto on 2/16/17.
 */

public class OfferHolder<T extends OffersAdapter> extends BaseHolder<T, Offer> {

    @BindView(R.id.nameText)
    @Getter
    TextView nameText;
    @BindView(R.id.priceText)
    @Getter
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

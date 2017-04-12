package com.danielspeixoto.ticket.view.recycler.holder;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.model.pojo.Payment;
import com.danielspeixoto.ticket.view.recycler.adapter.PaymentsAdapter;

import butterknife.BindView;
import lombok.Getter;

/**
 * Created by danielspeixoto on 2/15/17.
 */

public abstract class PaymentHolder<T extends PaymentsAdapter> extends BaseHolder<T, Payment> {

    @BindView(R.id.nameText)
    @Getter
    TextView nameText;
    @BindView(R.id.cardItem)
    CardView cardItem;

    public PaymentHolder(View itemView, T mAdapter) {
        super(itemView, mAdapter);
    }

    @Override
    public void onPostCreated() {
        nameText.setText(mItem.getName());
    }
}

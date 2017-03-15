package com.danielspeixoto.ticket.view.recycler.holder;

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

public class PaymentHolder<T extends PaymentsAdapter> extends BaseHolder<T, Payment> {

    @BindView(R.id.nameText)
    @Getter
    TextView nameText;

    public PaymentHolder(View itemView, T mAdapter) {
        super(itemView, mAdapter);
    }

    @Override
    public void onPostCreated() {
        nameText.setText(mItem.getName());
    }
}

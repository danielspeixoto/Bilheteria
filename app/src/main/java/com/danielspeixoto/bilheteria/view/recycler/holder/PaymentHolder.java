package com.danielspeixoto.bilheteria.view.recycler.holder;

import android.view.View;
import android.widget.TextView;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.model.pojo.Payment;
import com.danielspeixoto.bilheteria.view.recycler.adapter.PaymentsAdapter;

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

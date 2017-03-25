package com.danielspeixoto.ticket.view.recycler.holder;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.view.recycler.adapter.PaymentsBuyAdapter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by danielspeixoto on 2/18/17.
 */

public class PaymentBuyHolder extends PaymentHolder<PaymentsBuyAdapter> {

    private static float amount;
    @BindView(R.id.amountPicker)
    EditText amountEdit;

    public PaymentBuyHolder(View itemView, PaymentsBuyAdapter mAdapter) {
        super(itemView, mAdapter);
        amountEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                amount = mItem.getAmount();
                String text = getText(amountEdit);
                if (!(text.equals(EMPTY_STRING) || text.equals("."))) {
                    mItem.setAmount(Float.valueOf(text));
                } else {
                    mItem.setAmount(0);
                }
                mAdapter.onItemChanged(amount - mItem.getAmount());

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        mAdapter.addCallback(() -> amountEdit.setText(""));
    }

    @OnClick(R.id.cardItem)
    public void onItemTouched() {
        // Whenever an item is touched the remaining to be payed will be filled inside it
        float amount = mItem.getAmount();
        float toFillWith = Float.valueOf(getText(mAdapter.getPriceText()).substring(1));
        mItem.setAmount(toFillWith + amount);
        mAdapter.onItemChanged(-toFillWith);
        if (toFillWith != 0) {
            amountEdit.setText(String.valueOf(mItem.getAmount()));
        }

    }
}

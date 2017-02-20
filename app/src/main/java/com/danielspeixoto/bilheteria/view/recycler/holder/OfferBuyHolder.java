package com.danielspeixoto.bilheteria.view.recycler.holder;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.view.recycler.adapter.OffersBuyAdapter;

import butterknife.BindView;

/**
 * Created by danielspeixoto on 2/16/17.
 */

public class OfferBuyHolder extends OfferHolder<OffersBuyAdapter> {

    private static int amount;
    @BindView(R.id.amountEdit)
    EditText amountEdit;

    public OfferBuyHolder(View itemView, OffersBuyAdapter mAdapter) {
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
                    mItem.setAmount(Integer.valueOf(text));
                } else {
                    mItem.setAmount(0);
                }
                mAdapter.onItemChanged((mItem.getAmount() - amount) * mItem.getPrice());

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        mAdapter.addCallback(() -> amountEdit.setText("0"));
    }


}

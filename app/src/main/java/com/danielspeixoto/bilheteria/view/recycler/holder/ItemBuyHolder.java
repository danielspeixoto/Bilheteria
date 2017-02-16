package com.danielspeixoto.bilheteria.view.recycler.holder;

import android.view.View;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.helper.SimpleCallback;
import com.danielspeixoto.bilheteria.model.pojo.ItemInfo;
import com.danielspeixoto.bilheteria.view.custom.NumPicker;
import com.danielspeixoto.bilheteria.view.recycler.adapter.BaseRecyclerAdapter;
import com.danielspeixoto.bilheteria.view.recycler.adapter.ItemsBuyRecyclerAdapter;

import butterknife.BindView;
import lombok.Setter;

/**
 * Created by danielspeixoto on 2/16/17.
 */

public class ItemBuyHolder extends ItemHolder {

    @BindView(R.id.amountEdit)
    NumPicker amountEdit;

    @Setter
    private ItemInfo mItem;

    public ItemBuyHolder(View itemView, BaseRecyclerAdapter mAdapter) {
        super(itemView, mAdapter);
        amountEdit.setUp(new SimpleCallback() {
            @Override
            public void run() {
                ((ItemsBuyRecyclerAdapter) mAdapter).updatePrice(mItem.getPrice() * amountEdit.getAmountChanged());
            }
        });
    }


}

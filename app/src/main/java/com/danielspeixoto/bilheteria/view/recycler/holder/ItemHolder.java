package com.danielspeixoto.bilheteria.view.recycler.holder;

import android.view.View;
import android.widget.TextView;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.view.recycler.adapter.BaseRecyclerAdapter;

import butterknife.BindView;
import lombok.Getter;

/**
 * Created by danielspeixoto on 2/16/17.
 */

public class ItemHolder extends IdHolder {

    @BindView(R.id.nameText)
    @Getter
    TextView nameText;
    @BindView(R.id.priceText)
    @Getter
    TextView priceText;

    public ItemHolder(View itemView, BaseRecyclerAdapter mAdapter) {
        super(itemView, mAdapter);
    }
}

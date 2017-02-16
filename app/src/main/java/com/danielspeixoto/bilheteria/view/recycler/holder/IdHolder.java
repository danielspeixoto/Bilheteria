package com.danielspeixoto.bilheteria.view.recycler.holder;

import android.view.View;

import com.danielspeixoto.bilheteria.view.recycler.adapter.BaseRecyclerAdapter;

import lombok.Setter;

/**
 * Created by danielspeixoto on 2/15/17.
 */

public class IdHolder extends BaseHolder {

    @Setter
    protected String id;

    public IdHolder(View itemView, BaseRecyclerAdapter mAdapter) {
        super(itemView, mAdapter);
    }

}

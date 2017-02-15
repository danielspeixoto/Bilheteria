package com.danielspeixoto.bilheteria.view.recycler.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.danielspeixoto.bilheteria.view.recycler.adapter.BaseRecyclerAdapter;

import butterknife.ButterKnife;

/**
 * Created by danielspeixoto on 20/11/16.
 */
public abstract class BaseHolder extends RecyclerView.ViewHolder {

    protected BaseRecyclerAdapter mAdapter;

    public BaseHolder(View itemView, BaseRecyclerAdapter mAdapter) {
        super(itemView);
        this.mAdapter = mAdapter;
        ButterKnife.bind(this, itemView);
    }
}

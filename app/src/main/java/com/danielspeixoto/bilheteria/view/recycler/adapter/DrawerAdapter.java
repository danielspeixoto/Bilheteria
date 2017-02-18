package com.danielspeixoto.bilheteria.view.recycler.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.view.activity.BaseActivity;
import com.danielspeixoto.bilheteria.view.recycler.holder.BaseHolder;
import com.danielspeixoto.bilheteria.view.recycler.holder.DrawerHolder;

/**
 * Created by danielspeixoto on 05/12/16.
 */

public class DrawerAdapter extends BaseAdapter<String, BaseHolder<DrawerAdapter, String>> {

    public DrawerAdapter(BaseActivity activity) {
        super(activity);
        getItems();
    }

    @Override
    public void getItems() {
        addItem("History");
        addItem("Balance");
        addItem("Manage Items");
        addItem("Manage Users");
        addItem("Manage Payment");
        addItem("About");
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
        String item = data.get(position);
        DrawerHolder itemHolder = (DrawerHolder) holder;
        itemHolder.setIndex(position);
        itemHolder.getDrawerText().setText(item);
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DrawerHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.adapter_drawer_item, parent, false),
                this);
    }

}

package com.danielspeixoto.ticket.view.recycler.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.model.pojo.Link;
import com.danielspeixoto.ticket.view.activity.BaseActivity;
import com.danielspeixoto.ticket.view.recycler.holder.DrawerHolder;

/**
 * Created by danielspeixoto on 4/11/17.
 */

public class OptionsAdapter extends BaseAdapter<Link, DrawerHolder> {

    public OptionsAdapter(BaseActivity activity) {
        super(activity);
    }

    @Override
    public void getItems() {}

    @Override
    public DrawerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DrawerHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.adapter_drawer_item, parent, false),
                this);
    }

}

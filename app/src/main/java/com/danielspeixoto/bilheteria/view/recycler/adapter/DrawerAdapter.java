package com.danielspeixoto.bilheteria.view.recycler.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.model.pojo.Link;
import com.danielspeixoto.bilheteria.view.activity.BaseActivity;
import com.danielspeixoto.bilheteria.view.activity.OffersActivity;
import com.danielspeixoto.bilheteria.view.recycler.holder.DrawerHolder;

/**
 * Created by danielspeixoto on 05/12/16.
 */

public class DrawerAdapter extends BaseAdapter<Link, DrawerHolder> {

    public DrawerAdapter(BaseActivity activity) {
        super(activity);
        getItems();
    }

    @Override
    public void getItems() {
//        addItem("History");
//        addItem("Balance");
        addItem(new Link("Manage Offers", () -> activity.goToActivity(OffersActivity.class)));
//        addItem("Manage Users");
        addItem(new Link("Manage Payment", () -> activity.goToActivity(OffersActivity.class)));
//        addItem("About");
    }

    @Override
    public DrawerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DrawerHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.adapter_drawer_item, parent, false),
                this);
    }

}

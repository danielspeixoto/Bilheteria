package com.danielspeixoto.bilheteria.view.recycler.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.helper.Permissions;
import com.danielspeixoto.bilheteria.model.Connection;
import com.danielspeixoto.bilheteria.model.pojo.Link;
import com.danielspeixoto.bilheteria.view.activity.BaseActivity;
import com.danielspeixoto.bilheteria.view.activity.HistoryActivity;
import com.danielspeixoto.bilheteria.view.activity.OffersActivity;
import com.danielspeixoto.bilheteria.view.activity.PaymentsActivity;
import com.danielspeixoto.bilheteria.view.activity.UsersActivity;
import com.danielspeixoto.bilheteria.view.recycler.holder.DrawerHolder;

import java.util.HashMap;

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
        HashMap<String, Boolean> permissions = Connection.getCurrentUser().getPermissions();
        if (permissions.get(Permissions.VIEW_HISTORY)) {
            addItem(new Link("History", () -> activity.goToActivity(HistoryActivity.class)));
        }
        if (permissions.get(Permissions.MANAGE_OFFERS)) {
            addItem(new Link("Manage Offers", () -> activity.goToActivity(OffersActivity.class)));
        }
        if (permissions.get(Permissions.MANAGE_PAYMENT)) {
            addItem(new Link("Manage Payment", () -> activity.goToActivity(PaymentsActivity.class)));
        }
        if (permissions.get(Permissions.MANAGE_USERS)) {
            addItem(new Link("Manage Users", () -> activity.goToActivity(UsersActivity.class)));
        }
    }

    @Override
    public DrawerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DrawerHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.adapter_drawer_item, parent, false),
                this);
    }

}

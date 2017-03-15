package com.danielspeixoto.ticket.view.recycler.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.Permissions;
import com.danielspeixoto.ticket.model.Connection;
import com.danielspeixoto.ticket.model.pojo.Link;
import com.danielspeixoto.ticket.view.activity.BaseActivity;
import com.danielspeixoto.ticket.view.activity.HistoryActivity;
import com.danielspeixoto.ticket.view.activity.OffersActivity;
import com.danielspeixoto.ticket.view.activity.PaymentsActivity;
import com.danielspeixoto.ticket.view.activity.UsersActivity;
import com.danielspeixoto.ticket.view.recycler.holder.DrawerHolder;

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
            addItem(new Link(activity.getString(R.string.history), () -> activity.goToActivity(HistoryActivity.class)));
        }
        if (permissions.get(Permissions.MANAGE_OFFERS)) {
            addItem(new Link(activity.getString(R.string.manage_offers), () -> activity.goToActivity(OffersActivity.class)));
        }
        if (permissions.get(Permissions.MANAGE_PAYMENT)) {
            addItem(new Link(activity.getString(R.string.manage_payment), () -> activity.goToActivity(PaymentsActivity.class)));
        }
        if (permissions.get(Permissions.MANAGE_USERS)) {
            addItem(new Link(activity.getString(R.string.manage_users)
                    , () -> activity.goToActivity(UsersActivity.class)));
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

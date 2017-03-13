package com.danielspeixoto.bilheteria.view.recycler.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.helper.Permissions;
import com.danielspeixoto.bilheteria.model.pojo.Permission;
import com.danielspeixoto.bilheteria.view.activity.BaseActivity;
import com.danielspeixoto.bilheteria.view.recycler.holder.PermissionHolder;

/**
 * Created by danielspeixoto on 3/13/17.
 */

public class PermissionAdapter extends BaseAdapter<Permission, PermissionHolder> {

    public PermissionAdapter(BaseActivity activity) {
        super(activity);
        getItems();
    }

    @Override
    public void getItems() {
        for (Permission permission : Permissions.getPermissionsList()) {
            addItem(permission);
        }
    }

    @Override
    public PermissionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PermissionHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_permission, parent, false), this);
    }
}

package com.danielspeixoto.ticket.view.recycler.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.Permissions;
import com.danielspeixoto.ticket.model.pojo.Permission;
import com.danielspeixoto.ticket.view.activity.BaseActivity;
import com.danielspeixoto.ticket.view.recycler.holder.PermissionHolder;

import java.util.HashMap;
import java.util.Iterator;

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
	
	public void setPermissionsState(HashMap<String,Boolean> permissionsState) {
		Iterator<Permission> iterator = getIterator();
		while(iterator.hasNext()) {
			Permission permission = iterator.next();
			permission.setAllowed(permissionsState.get(permission.getName()));
		}
		notifyDataSetChanged();
    }
}

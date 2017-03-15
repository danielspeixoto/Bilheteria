package com.danielspeixoto.ticket.view.recycler.holder;

import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.model.pojo.Permission;
import com.danielspeixoto.ticket.view.recycler.adapter.PermissionAdapter;

import butterknife.BindView;

/**
 * Created by danielspeixoto on 3/13/17.
 */

public class PermissionHolder extends BaseHolder<PermissionAdapter, Permission> {

    @BindView(R.id.nameText)
    TextView nameText;
    @BindView(R.id.switchActivated)
    Switch switchActivated;

    public PermissionHolder(View itemView, PermissionAdapter mAdapter) {
        super(itemView, mAdapter);
        switchActivated.setOnClickListener(v -> {
            mItem.setAllowed(switchActivated.isChecked());
        });
    }

    @Override
    public void onPostCreated() {
        nameText.setText(mItem.getName());
    }
}

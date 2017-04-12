package com.danielspeixoto.ticket.view.activity;

import android.os.Bundle;
import android.widget.EditText;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.Permissions;
import com.danielspeixoto.ticket.model.pojo.User;
import com.danielspeixoto.ticket.view.custom.RecyclerList;
import com.danielspeixoto.ticket.view.recycler.adapter.PermissionAdapter;

import butterknife.BindView;
import butterknife.OnClick;

public abstract class UserDataActivity extends BaseActivity {

    @BindView(R.id.nameEdit)
    EditText nameEdit;
    @BindView(R.id.list)
    RecyclerList list;
    
    protected User mUser = new User();
    protected PermissionAdapter mAdapter = new PermissionAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState, int resLayout) {
        super.onCreate(savedInstanceState, resLayout);
        list.setNestedScrollEnabled(false);
        list.setAdapter(mAdapter);
    }

    @OnClick(R.id.fab)
    public void save() {
        mUser.setPermissions(Permissions.getPermissions(mAdapter.getData()));
        if (checkTextEmpty(nameEdit)) {
            nameEdit.requestFocus();
            showMessage(getString(R.string.name_must_fill));
        }  else {
            mUser.setName(getText(nameEdit));
        }
    }

}

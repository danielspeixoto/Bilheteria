package com.danielspeixoto.ticket.view.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.Permissions;
import com.danielspeixoto.ticket.model.pojo.User;
import com.danielspeixoto.ticket.module.InsertUser;
import com.danielspeixoto.ticket.presenter.InsertUserPresenter;
import com.danielspeixoto.ticket.view.recycler.adapter.PermissionAdapter;

import butterknife.BindView;
import butterknife.OnClick;

public class UserDataActivity extends BaseActivity implements InsertUser.View {

    @BindView(R.id.nameEdit)
    EditText nameEdit;
    @BindView(R.id.emailEdit)
    EditText emailEdit;
    @BindView(R.id.passEdit)
    EditText passEdit;
    @BindView(R.id.confirmPassEdit)
    EditText confirmPassEdit;
    @BindView(R.id.list)
    RecyclerView list;

    private InsertUser.Presenter mPresenter = new InsertUserPresenter(this);
    private User mUser = new User();
    private PermissionAdapter mAdapter = new PermissionAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_user_data);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setNestedScrollingEnabled(false);
        list.setAdapter(mAdapter);
    }

    @OnClick(R.id.fab)
    public void save() {
        mUser.setPermissions(Permissions.getPermissions(mAdapter.getData()));
        if (checkTextEmpty(nameEdit)) {
            nameEdit.requestFocus();
            showMessage(getString(R.string.name_must_fill));
        } else if (checkTextEmpty(emailEdit)) {
            emailEdit.requestFocus();
            showMessage(getString(R.string.email_must_fill));
        } else if (checkTextEmpty(passEdit)) {
            passEdit.requestFocus();
            showMessage(getString(R.string.password_must_fill));
        } else if (!passEdit.getText().toString().equals(confirmPassEdit.getText().toString())) {
            confirmPassEdit.requestFocus();
            showMessage(getString(R.string.password_must_match));
        } else {
            mUser.setName(nameEdit.getText().toString());
            mUser.setEmail(emailEdit.getText().toString());
            mUser.setPassword(passEdit.getText().toString());
            mPresenter.createUser(mUser);
        }
    }

}

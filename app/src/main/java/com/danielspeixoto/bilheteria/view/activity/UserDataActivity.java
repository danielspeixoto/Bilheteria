package com.danielspeixoto.bilheteria.view.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.helper.Permissions;
import com.danielspeixoto.bilheteria.model.pojo.User;
import com.danielspeixoto.bilheteria.module.InsertUser;
import com.danielspeixoto.bilheteria.presenter.InsertUserPresenter;
import com.danielspeixoto.bilheteria.view.recycler.adapter.PermissionAdapter;

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
            showMessage("Name must be filled");
        } else if (checkTextEmpty(emailEdit)) {
            emailEdit.requestFocus();
            showMessage("Email must be filled");
        } else if (checkTextEmpty(passEdit)) {
            passEdit.requestFocus();
            showMessage("Must have a password");
        } else if (!passEdit.getText().toString().equals(confirmPassEdit.getText().toString())) {
            confirmPassEdit.requestFocus();
            showMessage("Passwords must match");
        } else {
            mUser.setName(nameEdit.getText().toString());
            mUser.setEmail(emailEdit.getText().toString());
            mUser.setPassword(passEdit.getText().toString());
            mPresenter.createUser(mUser);
        }
    }

}

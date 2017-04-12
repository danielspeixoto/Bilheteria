package com.danielspeixoto.ticket.view.activity;

import android.os.Bundle;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.presenter.AllUsersPresenter;
import com.danielspeixoto.ticket.view.custom.RecyclerList;
import com.danielspeixoto.ticket.view.recycler.adapter.UsersAdapter;

import butterknife.BindView;
import butterknife.OnClick;

public class UsersActivity extends BaseActivity {

    @BindView(R.id.list)
    RecyclerList list;

    private UsersAdapter mAdapter = new UsersAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_users);
        activityInfo = getString(R.string.info_users);
        mAdapter.setPresenter(new AllUsersPresenter(mAdapter));
        list.setAdapter(mAdapter);
    }

    @OnClick(R.id.fab)
    public void createUser() {
        goToActivity(UserDataActivity.class);
    }

}

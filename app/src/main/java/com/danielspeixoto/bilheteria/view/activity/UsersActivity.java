package com.danielspeixoto.bilheteria.view.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.presenter.AllUsersPresenter;
import com.danielspeixoto.bilheteria.view.recycler.adapter.UserAdapter;

import butterknife.BindView;
import butterknife.OnClick;

public class UsersActivity extends BaseActivity {

    @BindView(R.id.list)
    RecyclerView list;

    private UserAdapter mAdapter = new UserAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_users);
        list.setLayoutManager(new LinearLayoutManager(this));
        mAdapter.setPresenter(new AllUsersPresenter(mAdapter));
        list.setAdapter(mAdapter);
    }

    @OnClick(R.id.fab)
    public void createUser() {
        goToActivity(UserDataActivity.class);
    }

}

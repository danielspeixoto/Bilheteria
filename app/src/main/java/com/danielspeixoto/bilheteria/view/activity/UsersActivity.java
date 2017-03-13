package com.danielspeixoto.bilheteria.view.activity;

import android.os.Bundle;

import com.danielspeixoto.bilheteria.R;

import butterknife.OnClick;

public class UsersActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_users);
    }

    @OnClick(R.id.fab)
    public void createUser() {
        goToActivity(UserDataActivity.class);
    }

}

package com.danielspeixoto.ticket.view.activity;

import android.os.Bundle;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.model.Connection;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Connection.isLogged()) {
            goToActivity(HomeActivity.class);
            finish();
        }
        super.onCreate(savedInstanceState, R.layout.activity_main);
        activityInfo = getString(R.string.info_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    @OnClick(R.id.signUpButton)
    public void signUp() {
        goToActivity(SignUpActivity.class);
    }

    @OnClick(R.id.haveAccountButton)
    public void logIn() {
        goToActivity(LoginActivity.class);
    }
}

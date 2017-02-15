package com.danielspeixoto.bilheteria.view.activity;

import android.os.Bundle;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.model.Connection;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Connection.isLogged(() -> {
            goToActivity(HomeActivity.class);
            finish();
        });
        super.onCreate(savedInstanceState, R.layout.activity_main);
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

package com.danielspeixoto.bilheteria.view;

import android.os.Bundle;

import com.danielspeixoto.bilheteria.R;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_main);
    }

    @OnClick(R.id.signUpButton)
    public void signUp() {
        goToActivity(SignUpActivity.class);
    }
}

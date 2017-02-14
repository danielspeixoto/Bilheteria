package com.danielspeixoto.bilheteria.view;

import android.os.Bundle;
import android.widget.EditText;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.model.pojo.User;
import com.danielspeixoto.bilheteria.module.SignUp;
import com.danielspeixoto.bilheteria.presenter.SignUpPresenter;

import butterknife.OnClick;

public class SignUpActivity extends BaseActivity implements SignUp.View {

    EditText nameEdit;
    EditText emailEdit;
    EditText passEdit;
    EditText confirmPassEdit;
    private SignUp.Presenter mPresenter;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_sign_up);
        mPresenter = new SignUpPresenter(this);
    }

    @OnClick(R.id.saveFab)
    public void saveUser() {
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
            user.setName(nameEdit.getText().toString());
            user.setEmail(emailEdit.getText().toString());
            user.setPassword(passEdit.getText().toString());
            mPresenter.signUp(user);
        }
    }

}

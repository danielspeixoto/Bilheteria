package com.danielspeixoto.ticket.view.activity;

import android.os.Bundle;
import android.widget.EditText;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.model.pojo.User;
import com.danielspeixoto.ticket.module.SignUp;
import com.danielspeixoto.ticket.presenter.SignUpPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class SignUpActivity extends BaseActivity implements SignUp.View {

    @BindView(R.id.nameEdit)
    EditText nameEdit;
    @BindView(R.id.emailEdit)
    EditText emailEdit;
    @BindView(R.id.passEdit)
    EditText passEdit;
    @BindView(R.id.confirmPassEdit)
    EditText confirmPassEdit;
    private SignUp.Presenter mPresenter;
    private User user = new User();

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

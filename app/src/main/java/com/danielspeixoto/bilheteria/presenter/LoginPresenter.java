package com.danielspeixoto.bilheteria.presenter;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.helper.App;
import com.danielspeixoto.bilheteria.model.Connection;
import com.danielspeixoto.bilheteria.model.pojo.User;
import com.danielspeixoto.bilheteria.module.Login;
import com.danielspeixoto.bilheteria.view.activity.BaseActivity;
import com.danielspeixoto.bilheteria.view.activity.HomeActivity;

import rx.SingleSubscriber;

/**
 * Created by danielspeixoto on 2/15/17.
 */

public class LoginPresenter implements Login.Presenter {

    private Login.View mView;
    private BaseActivity mActivity;

    public LoginPresenter(Login.View view) {
        mView = view;
        mActivity = mView.getActivity();
    }

    @Override
    public void logIn(String email, String password) {
        mActivity.showMessage(App.getStringResource(R.string.loading));
        Connection.logIn(email, password).subscribe(new SingleSubscriber<User>() {
            @Override
            public void onSuccess(User value) {
                mView.goToActivity(HomeActivity.class);
                mActivity.finish();
            }

            @Override
            public void onError(Throwable error) {
                mActivity.showMessage(error.getMessage());
            }
        });
    }
}

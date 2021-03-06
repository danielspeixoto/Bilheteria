package com.danielspeixoto.ticket.presenter;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.model.Connection;
import com.danielspeixoto.ticket.model.pojo.User;
import com.danielspeixoto.ticket.module.Login;
import com.danielspeixoto.ticket.util.Validate;
import com.danielspeixoto.ticket.view.activity.BaseActivity;
import com.danielspeixoto.ticket.view.activity.HomeActivity;

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
        User user = new User(email, password);
        String result = Validate.user(user);
        if (result.equals(Validate.OK)) {
            Connection.findUser(email, password).subscribe(new SingleSubscriber<User>() {
                @Override
                public void onSuccess(User user) {
                    Connection.logIn(user);
                    mView.goToActivity(HomeActivity.class);
                    mActivity.finish();
                }

                @Override
                public void onError(Throwable error) {
                    App.showMessage(error.getMessage());
                }
            });
        } else {
            App.showMessage(result);
        }
    }
}

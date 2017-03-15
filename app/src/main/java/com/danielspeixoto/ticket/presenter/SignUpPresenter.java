package com.danielspeixoto.ticket.presenter;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.model.CRUDUsers;
import com.danielspeixoto.ticket.model.Connection;
import com.danielspeixoto.ticket.model.pojo.User;
import com.danielspeixoto.ticket.module.SignUp;
import com.danielspeixoto.ticket.view.activity.BaseActivity;
import com.danielspeixoto.ticket.view.activity.HomeActivity;

import rx.SingleSubscriber;

/**
 * Created by danielspeixoto on 2/14/17.
 */

public class SignUpPresenter implements SignUp.Presenter {

    private SignUp.View mView;
    private BaseActivity mActivity;


    public SignUpPresenter(SignUp.View mView) {
        this.mView = mView;
        mActivity = mView.getActivity();
    }

    @Override
    public void signUp(User user) {
        App.showMessage(mActivity.getResources().getString(R.string.loading));
        CRUDUsers.createAdm(user).subscribe(new SingleSubscriber<User>() {
            @Override
            public void onSuccess(User user) {
                App.showMessage(App.getStringResource(R.string.user_added));
                Connection.logIn(user);
                mView.goToActivity(HomeActivity.class);
                mView.getActivity().finish();
            }

            @Override
            public void onError(Throwable error) {
                App.showMessage(error.getMessage());
            }
        });
    }
}

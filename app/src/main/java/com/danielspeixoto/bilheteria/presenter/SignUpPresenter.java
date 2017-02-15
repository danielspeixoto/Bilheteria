package com.danielspeixoto.bilheteria.presenter;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.model.CRUDUsers;
import com.danielspeixoto.bilheteria.model.Connection;
import com.danielspeixoto.bilheteria.model.pojo.User;
import com.danielspeixoto.bilheteria.module.SignUp;
import com.danielspeixoto.bilheteria.view.activity.BaseActivity;
import com.danielspeixoto.bilheteria.view.activity.HomeActivity;

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
        mView.getActivity().showMessage(mActivity.getResources().getString(R.string.loading));
        CRUDUsers.createAdm(user).subscribe(new SingleSubscriber<User>() {
            @Override
            public void onSuccess(User user) {
                mView.getActivity().showMessage("User created");
                Connection.logIn(user);
                mView.goToActivity(HomeActivity.class);
                mView.getActivity().finish();
            }

            @Override
            public void onError(Throwable error) {
                mView.getActivity().showMessage(error.getMessage());
            }
        });
    }
}

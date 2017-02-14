package com.danielspeixoto.bilheteria.presenter;

import com.danielspeixoto.bilheteria.model.CRUDUsers;
import com.danielspeixoto.bilheteria.model.pojo.User;
import com.danielspeixoto.bilheteria.module.SignUp;
import com.danielspeixoto.bilheteria.util.Connection;

import rx.SingleSubscriber;

/**
 * Created by danielspeixoto on 2/14/17.
 */

public class SignUpPresenter implements SignUp.Presenter {

    private SignUp.View mView;

    public SignUpPresenter(SignUp.View mView) {
        this.mView = mView;
    }

    @Override
    public void signUp(User user) {
        CRUDUsers.createAdm(user).subscribe(new SingleSubscriber<User>() {
            @Override
            public void onSuccess(User user) {
                mView.getActivity().showMessage("User created");
                Connection.logIn(user);
            }

            @Override
            public void onError(Throwable error) {
                mView.getActivity().showMessage("An error occurred");
            }
        });
    }
}

package com.danielspeixoto.bilheteria.presenter;

import com.danielspeixoto.bilheteria.helper.App;
import com.danielspeixoto.bilheteria.model.CRUDUsers;
import com.danielspeixoto.bilheteria.model.pojo.User;
import com.danielspeixoto.bilheteria.module.InsertUser;

import rx.SingleSubscriber;

/**
 * Created by danielspeixoto on 3/13/17.
 */

public class InsertUserPresenter implements InsertUser.Presenter {

    private InsertUser.View mView;


    public InsertUserPresenter(InsertUser.View mView) {
        this.mView = mView;
    }

    @Override
    public void createUser(User user) {
        CRUDUsers.createUser(user).subscribe(new SingleSubscriber<User>() {
            @Override
            public void onSuccess(User user) {
                App.showMessage("User created");
            }

            @Override
            public void onError(Throwable error) {
                App.showMessage(error.getMessage());
            }
        });
    }
}

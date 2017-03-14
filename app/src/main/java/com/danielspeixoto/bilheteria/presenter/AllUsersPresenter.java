package com.danielspeixoto.bilheteria.presenter;

import com.danielspeixoto.bilheteria.helper.App;
import com.danielspeixoto.bilheteria.model.CRUDUsers;
import com.danielspeixoto.bilheteria.model.pojo.User;
import com.danielspeixoto.bilheteria.module.Source;

import rx.Subscriber;

/**
 * Created by danielspeixoto on 3/13/17.
 */

public class AllUsersPresenter implements Source.Presenter {

    private Source.View<User> mView;

    public AllUsersPresenter(Source.View<User> view) {
        mView = view;
    }

    @Override
    public void syncItems() {
        CRUDUsers.getAll().subscribe(new Subscriber<User>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                App.showMessage(e.getMessage());
            }

            @Override
            public void onNext(User Payment) {
                mView.addItem(Payment);
            }
        });
    }
}
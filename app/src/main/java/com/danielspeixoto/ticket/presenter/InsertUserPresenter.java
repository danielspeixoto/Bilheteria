package com.danielspeixoto.ticket.presenter;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.model.CRUDUsers;
import com.danielspeixoto.ticket.model.pojo.User;
import com.danielspeixoto.ticket.module.InsertUser;
import com.danielspeixoto.ticket.util.Validate;

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
        String result = Validate.User(user);
        if (result.equals(Validate.OK)) {
            result = App.getStringResource(R.string.user_added);
            CRUDUsers.createUser(user).subscribe(new SingleSubscriber<User>() {
                @Override
                public void onSuccess(User user) {
                    App.showMessage(App.getStringResource(R.string.user_added));
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

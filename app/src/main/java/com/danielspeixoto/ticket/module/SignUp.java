package com.danielspeixoto.ticket.module;

import com.danielspeixoto.ticket.model.pojo.User;

/**
 * Created by danielspeixoto on 2/14/17.
 */

public class SignUp {

    public interface View extends ActivityBase.View {

    }

    public interface Presenter extends ActivityBase.Presenter {
        void signUp(User user);
    }
}

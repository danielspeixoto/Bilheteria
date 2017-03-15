package com.danielspeixoto.ticket.module;

import com.danielspeixoto.ticket.model.pojo.User;

/**
 * Created by danielspeixoto on 3/13/17.
 */

public class InsertUser {

    public interface View extends ActivityBase.View {

    }

    public interface Presenter extends ActivityBase.Presenter {
        void createUser(User user);
    }
}


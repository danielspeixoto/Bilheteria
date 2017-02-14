package com.danielspeixoto.bilheteria.util;

import com.danielspeixoto.bilheteria.model.pojo.User;

import lombok.Getter;

/**
 * Created by danielspeixoto on 2/14/17.
 */

public class Connection {

    @Getter
    private static User currentUser;

    public static void logIn(User user) {
        currentUser = user;
    }
}

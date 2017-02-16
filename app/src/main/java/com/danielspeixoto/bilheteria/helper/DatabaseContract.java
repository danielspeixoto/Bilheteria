package com.danielspeixoto.bilheteria.helper;

/**
 * Created by danielspeixoto on 2/14/17.
 */

public interface DatabaseContract {

    int ADMIN = 1;
    int MANAGER = 2;
    int SELLER = 3;

    String EMAIL = "email";
    String ADM = "adm";
    String NAME = "name";
    String LEVEL = "level";
    String PASSWORD = "password";
}

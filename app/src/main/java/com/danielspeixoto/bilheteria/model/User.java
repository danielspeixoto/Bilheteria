package com.danielspeixoto.bilheteria.model;

import lombok.Data;

/**
 * Created by danielspeixoto on 2/14/17.
 */

@Data
public class User {
    private String uid, name, email, password, admUid, level;

    public User(String uid, String name, String email, String password, String admUid, String level) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.password = password;
        this.admUid = admUid;
        this.level = level;

    }

}

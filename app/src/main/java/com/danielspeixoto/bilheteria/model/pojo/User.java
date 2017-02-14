package com.danielspeixoto.bilheteria.model.pojo;

import lombok.Data;

/**
 * Created by danielspeixoto on 2/14/17.
 */

@Data
public class User {
    int level;
    private String name, email, password, adm;

    public User(String name, String email, String password, String adm, int level) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.adm = adm;
        this.level = level;

    }

}

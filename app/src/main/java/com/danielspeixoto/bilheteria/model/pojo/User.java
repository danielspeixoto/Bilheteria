package com.danielspeixoto.bilheteria.model.pojo;

import java.util.HashMap;

import lombok.Data;

/**
 * Created by danielspeixoto on 2/14/17.
 */

@Data
public class User {
    private HashMap<String, Boolean> permissions;
    private String name, email, password, adm;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String password, String adm, HashMap<String, Boolean> permissions) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.adm = adm;
        this.permissions = permissions;

    }

}

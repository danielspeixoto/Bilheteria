package com.danielspeixoto.bilheteria.model.pojo;

import lombok.Data;

/**
 * Created by danielspeixoto on 3/13/17.
 */

@Data
public class Permission {

    String name;
    boolean isAllowed = false;

    public Permission(String name, boolean isAllowed) {
        this.name = name;
        this.isAllowed = isAllowed;
    }
}

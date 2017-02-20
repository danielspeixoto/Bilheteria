package com.danielspeixoto.bilheteria.model.pojo;

import com.danielspeixoto.bilheteria.helper.SimpleCallback;

import lombok.Data;

/**
 * Created by danielspeixoto on 2/20/17.
 */
@Data
public class Link {

    private String name;
    private SimpleCallback callback;

    public Link(String name, SimpleCallback callback) {
        this.name = name;
        this.callback = callback;
    }

}

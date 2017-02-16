package com.danielspeixoto.bilheteria.model.pojo;

import java.sql.Timestamp;
import java.util.ArrayList;

import lombok.Data;

/**
 * Created by danielspeixoto on 2/14/17.
 */
@Data
public class Ticket {
    private String uid, identification, observations, seller;
    private Timestamp timestamp;
    private ArrayList<Item> items;
    private ArrayList<Payment> payments;

}

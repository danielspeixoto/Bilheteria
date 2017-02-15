package com.danielspeixoto.bilheteria.model.pojo;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Created by danielspeixoto on 2/14/17.
 */

public class Ticket {
    String uid, identification, observations, seller;
    Timestamp timestamp;
    ArrayList<Item> items;
    ArrayList<Payment> payments;

}

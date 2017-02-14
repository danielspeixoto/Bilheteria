package com.danielspeixoto.bilheteria.model.pojo;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Created by danielspeixoto on 2/14/17.
 */

public class Ticket {
    String uid, identification, observations;
    Timestamp timestamp;
    ArrayList<Item> items;
    ArrayList<Payment> payments;

    public Ticket(String uid, String identification, String observations, Timestamp timestamp, ArrayList<Item> items, ArrayList<Payment> payments) {
        this.uid = uid;
        this.identification = identification;
        this.observations = observations;
        this.timestamp = timestamp;
        this.items = items;
        this.payments = payments;
    }
}

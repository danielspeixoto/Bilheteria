package com.danielspeixoto.bilheteria.model.pojo;

import java.util.List;

import lombok.Data;

/**
 * Created by danielspeixoto on 2/14/17.
 */
@Data
public class Ticket {
    private String uid, identification, observations, seller;
    private long timestamp;
    private List<Offer> offers;
    private List<Payment> payments;

    public Ticket(String identification, String observations, String seller, long timestamp, List<Offer> offers, List<Payment> payments) {
        this.identification = identification;
        this.observations = observations;
        this.seller = seller;
        this.timestamp = timestamp;
        this.offers = offers;
        this.payments = payments;
    }

    public Ticket() {
    }

    public void addOffer(Offer offer) {
        offers.add(offer);
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
    }


}

package com.danielspeixoto.ticket.model;

import android.util.Pair;

import com.danielspeixoto.ticket.model.pojo.Offer;
import com.danielspeixoto.ticket.model.pojo.Payment;
import com.danielspeixoto.ticket.model.pojo.PaymentReport;
import com.danielspeixoto.ticket.model.pojo.Ticket;
import com.danielspeixoto.ticket.model.pojo.OfferReport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

/**
 * Created by danielspeixoto on 4/7/17.
 */

public class Report {

    @Getter
    private HashMap<String, Pair<Integer, Double>> offers = new HashMap<>();
    @Getter
    private HashMap<String, Double> payments = new HashMap<>();

    private static String index;

    public Report() {}

    public void addOffer(Offer offer) {
        index = offer.getAmount() > 0 ? offer.getName() : offer.getName() + " (Cancelado)";
        if(offers.containsKey(index)) {
            Pair<Integer, Double> pair = offers.get(index);
            offers.put(index, new Pair<>(pair.first + offer.getAmount(),
		            pair.second + offer.getPrice() * offer.getAmount()));
        } else {
            offers.put(index, new Pair<>(offer.getAmount(),
		            (double) offer.getPrice() * offer.getAmount()));
        }
    }
    
    public void addPayment(Payment payment) {
        index = payment.getAmount() > 0 ? payment.getName() : payment.getName() + " (Cancelado)";
        if(payments.containsKey(index)) {
            double amount = payments.get(index);
            payments.put(index, amount + payment.getAmount());
        } else {
            payments.put(index, (double) payment.getAmount());
        }
    }
    
    public void addTicket(Ticket ticket) {
	    for (Offer offer : ticket.getOffers()) {
		    addOffer(offer);
	    }
	    for (Payment payment : ticket.getPayments()) {
		    addPayment(payment);
	    }
    }
    
    public ArrayList<PaymentReport> getPayments() {
	    ArrayList<PaymentReport> arrayList = new ArrayList<>();
	    for (Map.Entry<String, Double> entry : payments.entrySet()) {
	        arrayList.add(new PaymentReport(entry.getKey(), entry.getValue()));
	    }
	    return arrayList;
    }
	
	public ArrayList<OfferReport> getOffers() {
		ArrayList<OfferReport> arrayList = new ArrayList<>();
		for (Map.Entry<String, Pair<Integer, Double>> entry : offers.entrySet()) {
			arrayList.add(new OfferReport(entry.getKey(),
					entry.getValue().first,
					entry.getValue().second));
		}
		return arrayList;
	}

}

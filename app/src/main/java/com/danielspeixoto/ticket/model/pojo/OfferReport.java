package com.danielspeixoto.ticket.model.pojo;

import lombok.Data;

/**
 * Created by danielspeixoto on 4/8/17.
 */
@Data
public class OfferReport {
	
	public OfferReport(String name, int numItems, double amount) {
		this.name = name;
		this.numItems = numItems;
		this.amount = amount;
	}
	
	private String name;
	private int numItems;
	private double amount;
}

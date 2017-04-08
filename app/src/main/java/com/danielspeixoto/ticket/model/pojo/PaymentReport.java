package com.danielspeixoto.ticket.model.pojo;

import lombok.Data;

/**
 * Created by danielspeixoto on 4/7/17.
 */
@Data
public class PaymentReport {
	
	public PaymentReport(String name, double amount) {
		this.name = name;
		this.amount = amount;
	}
	
	private String name;
	private double amount;
}

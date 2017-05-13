package com.danielspeixoto.ticket.view.recycler.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.model.Report;
import com.danielspeixoto.ticket.model.pojo.PaymentReport;
import com.danielspeixoto.ticket.view.activity.BaseActivity;
import com.danielspeixoto.ticket.view.recycler.holder.PaymentReportHolder;

/**
 * Created by danielspeixoto on 4/7/17.
 */

public class PaymentsReportAdapter extends BaseAdapter<PaymentReport, PaymentReportHolder> {
	
	double total = 0;
	
	private Report mReport = new Report();
	
	public PaymentsReportAdapter(BaseActivity activity) {
		super(activity);
		addItem(new PaymentReport(App.getStringResource(R.string.total), total));
	}
	
	public void setMReport(Report mReport) {
		clearData();
		total = 0;
		this.mReport = mReport;
		getItems();
	}
	
	@Override
	public void getItems() {
		clearData();
		for(PaymentReport paymentReport : mReport.getPayments()) {
			addItem(paymentReport);
		}
		addItem(new PaymentReport(App.getStringResource(R.string.total), total));
	}
	
	@Override
	public void addItem(PaymentReport paymentReport) {
		super.addItem(paymentReport);
		total += paymentReport.getAmount();
	}
	
	@Override
	public PaymentReportHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new PaymentReportHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_payment_report, parent, false), this);
	}
}

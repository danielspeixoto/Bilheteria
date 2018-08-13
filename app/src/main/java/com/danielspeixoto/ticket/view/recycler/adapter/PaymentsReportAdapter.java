package com.danielspeixoto.ticket.view.recycler.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.model.Report;
import com.danielspeixoto.ticket.model.pojo.PaymentReport;
import com.danielspeixoto.ticket.view.activity.BaseActivity;
import com.danielspeixoto.ticket.view.recycler.holder.PaymentReportHolder;

import java.util.Iterator;

/**
 * Created by danielspeixoto on 4/7/17.
 */

public class PaymentsReportAdapter extends BaseAdapter<PaymentReport, PaymentReportHolder> {
	
	double total = 0;
	OffersReportAdapter.Filter filter;
	private Report mReport = new Report();

	public PaymentsReportAdapter(BaseActivity activity, boolean hasFilter) {
		super(activity);
		if (hasFilter) {
			this.filter = new OffersReportAdapter.Filter("*");
		}
		addItem(new PaymentReport(App.getStringResource(R.string.total), this.total));
	}

	public void setMReport(Report mReport) {
		clearData();
		this.total = 0.0d;
		this.mReport = mReport;
		getItems();
	}

	public void getItems() {
		clearData();
		Iterator it = this.mReport.getPayments().iterator();
		while (it.hasNext()) {
			PaymentReport paymentReport = (PaymentReport) it.next();
			if (this.filter == null) {
				addItem(paymentReport);
			}
		}
		addItem(new PaymentReport(App.getStringResource(R.string.total), this.total));
	}

	public void addItem(PaymentReport paymentReport) {
		super.addItem(paymentReport);
		this.total += paymentReport.getAmount();
	}

	public PaymentReportHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new PaymentReportHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_payment_report, parent, false), this);
	}
}

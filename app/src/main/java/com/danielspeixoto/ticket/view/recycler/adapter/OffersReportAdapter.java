package com.danielspeixoto.ticket.view.recycler.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.model.Report;
import com.danielspeixoto.ticket.model.pojo.OfferReport;
import com.danielspeixoto.ticket.view.activity.BaseActivity;
import com.danielspeixoto.ticket.view.recycler.holder.OfferReportHolder;

/**
 * Created by danielspeixoto on 4/8/17.
 */

public class OffersReportAdapter extends BaseAdapter<OfferReport, OfferReportHolder> {
	
	private double amount = 0;
	private int numItems = 0;
	
	private Report mReport = new Report();
	
	public OffersReportAdapter(BaseActivity activity) {
		super(activity);
	}
	
	public void setMReport(Report mReport) {
		data.clear();
		amount = 0;
		numItems = 0;
		this.mReport = mReport;
		getItems();
	}
	
	@Override
	public void getItems() {
		for(OfferReport container : mReport.getOffers()) {
			addItem(container);
		}
		addItem(new OfferReport(App.getStringResource(R.string.total), numItems,  amount));
	}
	
	@Override
	public void addItem(OfferReport offerReport) {
		super.addItem(offerReport);
		amount += offerReport.getAmount();
		numItems += offerReport.getNumItems();
	}
	
	@Override
	public OfferReportHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new OfferReportHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_offer_report, parent, false), this);
	}
}

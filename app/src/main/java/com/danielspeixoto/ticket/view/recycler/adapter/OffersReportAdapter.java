package com.danielspeixoto.ticket.view.recycler.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.model.Report;
import com.danielspeixoto.ticket.model.pojo.OfferReport;
import com.danielspeixoto.ticket.view.activity.BaseActivity;
import com.danielspeixoto.ticket.view.recycler.holder.OfferReportHolder;

import java.util.Iterator;

/**
 * Created by danielspeixoto on 4/8/17.
 */

public class OffersReportAdapter extends BaseAdapter<OfferReport, OfferReportHolder> {
	
	private double amount = 0;
	private int numItems = 0;
	Filter filter;
	private Report mReport = new Report();

	public static class Filter {
		private String pattern;

		public Filter(String pattern) {
			this.pattern = pattern;
		}

		public boolean accept(OfferReport offer) {
			return offer.getName().contains(this.pattern);
		}
	}

	public OffersReportAdapter(BaseActivity activity, boolean hasFilter) {
		super(activity);
		if (hasFilter) {
			this.filter = new Filter("*");
		}
		addItem(new OfferReport(App.getStringResource(R.string.total), this.numItems, this.amount));
	}

	
	public void setMReport(Report mReport) {
		clearData();
		amount = 0;
		numItems = 0;
		this.mReport = mReport;
		getItems();
	}
	
	@Override
	public void getItems() {
		clearData();
		Iterator it = this.mReport.getOffers().iterator();
		while (it.hasNext()) {
			OfferReport container = (OfferReport) it.next();
			if (this.filter == null || this.filter.accept(container)) {
				addItem(container);
			}
		}
		addItem(new OfferReport(App.getStringResource(R.string.total), this.numItems, this.amount));
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

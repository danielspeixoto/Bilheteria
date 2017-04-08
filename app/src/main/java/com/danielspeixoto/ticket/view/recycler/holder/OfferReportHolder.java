package com.danielspeixoto.ticket.view.recycler.holder;

/**
 * Created by danielspeixoto on 4/8/17.
 */

import android.widget.TextView;
import android.view.View;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.model.pojo.OfferReport;
import com.danielspeixoto.ticket.view.recycler.adapter.OffersReportAdapter;

import butterknife.BindView;

public class OfferReportHolder extends BaseHolder<OffersReportAdapter, OfferReport> {
	
	@BindView(R.id.nameText)
	TextView nameText;
	@BindView(R.id.amountText)
	TextView amountText;
	@BindView(R.id.numText)
	TextView numText;
	
	public OfferReportHolder(View itemView, OffersReportAdapter mAdapter) {
		super(itemView, mAdapter);
	}
	
	@Override
	public void onPostCreated() {
		nameText.setText(mItem.getName());
		numText.setText(String.valueOf(mItem.getNumItems()));
		amountText.setText(String.valueOf(mItem.getAmount()));
	}
}

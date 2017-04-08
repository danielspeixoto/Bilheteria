package com.danielspeixoto.ticket.view.recycler.holder;

import android.view.View;
import android.widget.TextView;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.model.pojo.PaymentReport;
import com.danielspeixoto.ticket.view.recycler.adapter.PaymentsReportAdapter;

import butterknife.BindView;

/**
 * Created by danielspeixoto on 4/7/17.
 */

public class PaymentReportHolder extends BaseHolder<PaymentsReportAdapter , PaymentReport> {
	
	@BindView(R.id.nameText)
	TextView nameText;
	@BindView(R.id.amountText)
	TextView amountText;
	
	public PaymentReportHolder(View itemView, PaymentsReportAdapter mAdapter) {
		super(itemView, mAdapter);
	}
	
	@Override
	public void onPostCreated() {
		nameText.setText(mItem.getName());
		amountText.setText(String.valueOf(mItem.getAmount()));
	}
}

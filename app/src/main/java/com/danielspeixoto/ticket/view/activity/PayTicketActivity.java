package com.danielspeixoto.ticket.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.model.pojo.Ticket;
import com.danielspeixoto.ticket.module.InsertTicket;
import com.danielspeixoto.ticket.module.OnItemChanged;
import com.danielspeixoto.ticket.presenter.AllPaymentsPresenter;
import com.danielspeixoto.ticket.presenter.InsertTicketPresenter;
import com.danielspeixoto.ticket.view.custom.RecyclerList;
import com.danielspeixoto.ticket.view.recycler.adapter.PaymentsBuyAdapter;

import butterknife.BindView;
import butterknife.OnClick;

public class PayTicketActivity extends BaseActivity implements OnItemChanged<Float>, InsertTicket.View {
	
	@BindView(R.id.paymentsList)
	RecyclerList paymentsList;
	@BindView(R.id.payText)
	TextView payText;
	@BindView(R.id.priceText)
	TextView priceText;
	
	private InsertTicket.Presenter mPresenter;
	private PaymentsBuyAdapter mPaymentsAdapter = new PaymentsBuyAdapter(this, this);
	private Ticket ticket;
	private final String MESSAGE = "message";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, R.layout.activity_pay_ticket);
		activityInfo = getString(R.string.info_pay_ticket);
		ticket = getIntent().getParcelableExtra(Ticket.class.getSimpleName());
		onItemChanged(ticket.getPrice());
		priceText.setText("$" + String.valueOf(ticket.getPrice()));
		mPaymentsAdapter.setPresenter(new AllPaymentsPresenter(mPaymentsAdapter));
		mPaymentsAdapter.setPriceText(payText);
		paymentsList.setNestedScrollEnabled(false);
		paymentsList.setAdapter(mPaymentsAdapter);
		mPresenter = new InsertTicketPresenter(this);
	}
	@OnClick(R.id.save)
	public void save() {
		if (!getText(payText).equals("$0.0")) {
			showMessage(getString(R.string.payment_not_completed));
		} else {
			ticket.setPayments(mPaymentsAdapter.getNotZero());
			mPresenter.insert(ticket);
		}
	}
	
	@Override
	public void onItemChanged(Float valueChanged) {
		float newValue = (Float.valueOf(payText.getText().toString().substring(1)) + valueChanged);
		payText.setText("$" + newValue);
		if(newValue > 0) {
			payText.setTextColor(App.getContext().getResources().getColor(android.R.color.holo_red_dark));
		} else {
			payText.setTextColor(App.getContext().getResources().getColor(android.R.color.holo_green_dark));
		}
	}

	@Override
	public void onResult(String message) {
		// Go back to ticketData, check if there is not a better way to consume less data
		Intent intent = new Intent(this, TicketDataActivity.class);
		intent.putExtra(MESSAGE, message);
		setResult(RESULT_OK, intent);
		finish();
	}
}

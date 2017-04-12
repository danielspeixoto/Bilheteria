package com.danielspeixoto.ticket.view.recycler.holder;

import android.view.View;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.model.pojo.Link;
import com.danielspeixoto.ticket.module.DeletePayment;
import com.danielspeixoto.ticket.presenter.DeletePaymentPresenter;
import com.danielspeixoto.ticket.view.dialog.AreYouSureDialog;
import com.danielspeixoto.ticket.view.dialog.OptionsDialog;
import com.danielspeixoto.ticket.view.recycler.adapter.PaymentsShowAdapter;

import java.util.ArrayList;

/**
 * Created by danielspeixoto on 4/11/17.
 */

public class PaymentShowHolder extends PaymentHolder<PaymentsShowAdapter> implements DeletePayment.View {
	public PaymentShowHolder(View itemView, PaymentsShowAdapter mAdapter) {
		super(itemView, mAdapter);
		OptionsDialog dialog = new OptionsDialog(getActivity());
		ArrayList<Link> links = new ArrayList<>();
		// DELETE PAYMENT
		links.add(new Link(App.getStringResource(R.string.delete), () -> {
			AreYouSureDialog areYouSureDialog = new AreYouSureDialog(() -> new DeletePaymentPresenter(PaymentShowHolder.this).delete(mItem));
			areYouSureDialog.show(getActivity().getSupportFragmentManager(), AreYouSureDialog.TAG);
			dialog.dismiss();
		}));
		dialog.setLinks(links);
		cardItem.setOnLongClickListener((l) -> {
			dialog.show();
			return true;
		});
	}
	
	@Override
	public void onDeleted() {
		mAdapter.getItems();
	}
}

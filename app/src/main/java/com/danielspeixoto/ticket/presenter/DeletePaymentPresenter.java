package com.danielspeixoto.ticket.presenter;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.model.CRUDPayments;
import com.danielspeixoto.ticket.model.pojo.Payment;
import com.danielspeixoto.ticket.module.DeletePayment;

/**
 * Created by danielspeixoto on 4/11/17.
 */

public class DeletePaymentPresenter implements DeletePayment.Presenter {
	
	private DeletePayment.View mView;
	
	public DeletePaymentPresenter(DeletePayment.View view) {
		mView = view;
	}
	
	@Override
	public void delete(Payment payment) {
		CRUDPayments.delete(payment.getUid());
		mView.getActivity().showMessage(App.getStringResource(R.string.payment_deleted));
		mView.onDeleted();
	}
}
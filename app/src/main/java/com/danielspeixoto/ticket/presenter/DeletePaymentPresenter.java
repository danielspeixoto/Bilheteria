package com.danielspeixoto.ticket.presenter;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.model.CRUDPayments;
import com.danielspeixoto.ticket.model.pojo.Payment;
import com.danielspeixoto.ticket.module.DeletePayment;

import rx.SingleSubscriber;

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
		CRUDPayments.delete(payment.getUid()).subscribe(new SingleSubscriber<Boolean>() {
			@Override
			public void onSuccess(Boolean aBoolean) {
				if(aBoolean) {
					mView.getActivity().showMessage(App.getStringResource(R.string.payment_deleted));
					mView.onDeleted();
				} else {
					App.showMessage(App.getStringResource(R.string.no_connection));
				}
			}

			@Override
			public void onError(Throwable throwable) {
				App.showMessage(App.getStringResource(R.string.error_occurred));
			}
		});
	}
}
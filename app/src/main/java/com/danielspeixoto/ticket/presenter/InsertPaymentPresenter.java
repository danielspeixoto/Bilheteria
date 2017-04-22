package com.danielspeixoto.ticket.presenter;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.model.CRUDPayments;
import com.danielspeixoto.ticket.model.pojo.Payment;
import com.danielspeixoto.ticket.module.InsertPayment;
import com.danielspeixoto.ticket.util.Validate;

import rx.SingleSubscriber;

/**
 * Created by danielspeixoto on 2/15/17.
 */

public class InsertPaymentPresenter implements InsertPayment.Presenter {

    private InsertPayment.View mView;

    public InsertPaymentPresenter(InsertPayment.View view) {
        mView = view;
    }

    @Override
    public void insert(Payment payment) {
        String result = Validate.payment(payment);
        if (result.equals(Validate.OK)) {
            CRUDPayments.insert(payment).subscribe(new SingleSubscriber<Boolean>() {
                @Override
                public void onSuccess(Boolean aBoolean) {
                    if(aBoolean) {
                        App.showMessage(App.getStringResource(R.string.payment_added));
                        mView.clear();
                    } else {
                        App.showMessage(App.getStringResource(R.string.no_connection));
                    }
                }

                @Override
                public void onError(Throwable throwable) {
                    App.showMessage(App.getStringResource(R.string.error_occurred));
                }
            });
        } else {
            App.showMessage(result);
        }
    }
}

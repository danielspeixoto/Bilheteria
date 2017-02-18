package com.danielspeixoto.bilheteria.presenter;

import com.danielspeixoto.bilheteria.helper.App;
import com.danielspeixoto.bilheteria.model.CRUDPayments;
import com.danielspeixoto.bilheteria.model.pojo.Payment;
import com.danielspeixoto.bilheteria.module.Source;

import rx.Subscriber;

/**
 * Created by danielspeixoto on 2/16/17.
 */

public class AllPaymentsPresenter implements Source.Presenter {

    private Source.View<Payment> mView;

    public AllPaymentsPresenter(Source.View<Payment> view) {
        mView = view;
    }

    @Override
    public void getItems() {
        CRUDPayments.getAll().subscribe(new Subscriber<Payment>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                App.showMessage(e.getMessage());
            }

            @Override
            public void onNext(Payment Payment) {
                mView.addItem(Payment);
            }
        });
    }
}

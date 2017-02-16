package com.danielspeixoto.bilheteria.presenter;

import com.danielspeixoto.bilheteria.model.CRUDPayments;
import com.danielspeixoto.bilheteria.model.pojo.PaymentInfo;
import com.danielspeixoto.bilheteria.module.Source;

import rx.Subscriber;

/**
 * Created by danielspeixoto on 2/16/17.
 */

public class AllPaymentsPresenter implements Source.Presenter {

    private Source.View<PaymentInfo> mView;

    public AllPaymentsPresenter(Source.View<PaymentInfo> view) {
        mView = view;
    }

    @Override
    public void getItems() {
        CRUDPayments.getAll().subscribe(new Subscriber<PaymentInfo>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                mView.getActivity().showMessage(e.getMessage());
            }

            @Override
            public void onNext(PaymentInfo paymentInfo) {
                mView.addItem(paymentInfo);
            }
        });
    }
}

package com.danielspeixoto.bilheteria.presenter;

import com.danielspeixoto.bilheteria.helper.App;
import com.danielspeixoto.bilheteria.model.CRUDOffers;
import com.danielspeixoto.bilheteria.model.pojo.Offer;
import com.danielspeixoto.bilheteria.module.Source;

import rx.Subscriber;

/**
 * Created by danielspeixoto on 2/15/17.
 */

public class AllItemsPresenter implements Source.Presenter {

    private Source.View<Offer> mView;

    public AllItemsPresenter(Source.View<Offer> view) {
        mView = view;
    }

    @Override
    public void getItems() {
        CRUDOffers.getAll().subscribe(new Subscriber<Offer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                App.showMessage(e.getMessage());
            }

            @Override
            public void onNext(Offer Payment) {
                mView.addItem(Payment);
            }
        });
    }
}
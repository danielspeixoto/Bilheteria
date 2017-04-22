package com.danielspeixoto.ticket.presenter;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.model.CRUDOffers;
import com.danielspeixoto.ticket.model.pojo.Offer;
import com.danielspeixoto.ticket.module.DeleteOffer;

import rx.SingleSubscriber;

/**
 * Created by danielspeixoto on 4/11/17.
 */

public class DeleteOfferPresenter implements DeleteOffer.Presenter {

    private DeleteOffer.View mView;

    public DeleteOfferPresenter(DeleteOffer.View view) {
        mView = view;
    }

    @Override
    public void delete(Offer offer) {
        CRUDOffers.delete(offer.getUid()).subscribe(new SingleSubscriber<Boolean>() {
            @Override
            public void onSuccess(Boolean aBoolean) {
                if(aBoolean) {
                    mView.getActivity().showMessage(App.getStringResource(R.string.offer_deleted));
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
        mView.getActivity().showMessage(App.getStringResource(R.string.offer_deleted));
        mView.onDeleted();
    }
}

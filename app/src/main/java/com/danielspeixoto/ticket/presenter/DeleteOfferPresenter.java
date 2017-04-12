package com.danielspeixoto.ticket.presenter;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.model.CRUDOffers;
import com.danielspeixoto.ticket.model.pojo.Offer;
import com.danielspeixoto.ticket.module.DeleteOffer;

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
        CRUDOffers.delete(offer.getUid());
        mView.getActivity().showMessage(App.getStringResource(R.string.offer_deleted));
        mView.onDeleted();
    }
}

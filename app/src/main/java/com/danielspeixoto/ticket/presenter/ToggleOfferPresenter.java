package com.danielspeixoto.ticket.presenter;

import com.danielspeixoto.ticket.model.CRUDOffers;
import com.danielspeixoto.ticket.module.ToggleOffer;

/**
 * Created by danielspeixoto on 2/20/17.
 */

public class ToggleOfferPresenter implements ToggleOffer.Presenter {

    private ToggleOffer.View mView;

    public ToggleOfferPresenter(ToggleOffer.View view) {
        mView = view;
    }

    @Override
    public void update(String UID, boolean isActivated) {
        CRUDOffers.toggleActivated(UID, isActivated);
    }
}

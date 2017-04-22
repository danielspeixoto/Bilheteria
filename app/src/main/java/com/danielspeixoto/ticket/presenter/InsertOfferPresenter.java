package com.danielspeixoto.ticket.presenter;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.model.CRUDOffers;
import com.danielspeixoto.ticket.model.pojo.Offer;
import com.danielspeixoto.ticket.module.InsertOffer;
import com.danielspeixoto.ticket.util.Validate;

/**
 * Created by danielspeixoto on 2/14/17.
 */

public class InsertOfferPresenter implements InsertOffer.Presenter {

    private InsertOffer.View mView;

    public InsertOfferPresenter(InsertOffer.View mView) {
        this.mView = mView;
    }

    @Override
    public void save(Offer offer) {
        String result = Validate.offer(offer);
        if (result.equals(Validate.OK)) {
            CRUDOffers.insert(offer);
            result = App.getStringResource(R.string.offer_added);
            mView.onSaveSuccess();
        }
        App.showMessage(result);
    }
}

package com.danielspeixoto.bilheteria.presenter;

import com.danielspeixoto.bilheteria.model.CRUDOffers;
import com.danielspeixoto.bilheteria.model.pojo.Offer;
import com.danielspeixoto.bilheteria.module.InsertOffer;
import com.danielspeixoto.bilheteria.util.Validate;

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
        String result = Validate.Offer(offer);
        if (result.equals(Validate.OK)) {
            CRUDOffers.insertOffer(offer);
            result = "Offer has been added";
            mView.getDialog().dismiss();
        }
        mView.getDialog().getActivity().showMessage(result);
    }
}

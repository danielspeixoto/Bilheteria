package com.danielspeixoto.ticket.presenter;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.model.CRUDOffers;
import com.danielspeixoto.ticket.model.pojo.Offer;
import com.danielspeixoto.ticket.module.UpdateOffer;
import com.danielspeixoto.ticket.util.Validate;

import rx.SingleSubscriber;

/**
 * Created by danielspeixoto on 4/11/17.
 */

public class UpdateOfferPresenter implements UpdateOffer.Presenter {

    private UpdateOffer.View mView;

    public UpdateOfferPresenter(UpdateOffer.View view) {
        mView = view;
    }


    @Override
    public void save(Offer offer) {
        String result = Validate.offer(offer);
        if (result.equals(Validate.OK)) {
            CRUDOffers.update(offer).subscribe(new SingleSubscriber<Boolean>() {
                @Override
                public void onSuccess(Boolean aBoolean) {
                    if(aBoolean) {
                        App.showMessage(App.getStringResource(R.string.offer_updated));
                        mView.onSaveSuccess();
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

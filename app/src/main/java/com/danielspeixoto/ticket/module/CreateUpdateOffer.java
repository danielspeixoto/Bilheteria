package com.danielspeixoto.ticket.module;

import com.danielspeixoto.ticket.model.pojo.Offer;

/**
 * Created by danielspeixoto on 2/14/17.
 */

public class CreateUpdateOffer {

    public interface View extends ActivityBase.View {
        void onSaveSuccess();
    }

    public interface Presenter extends ActivityBase.Presenter {
        void save(Offer offer);
    }

}

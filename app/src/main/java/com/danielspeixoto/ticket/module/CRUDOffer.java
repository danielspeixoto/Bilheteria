package com.danielspeixoto.ticket.module;

import com.danielspeixoto.ticket.model.pojo.Offer;

/**
 * Created by danielspeixoto on 2/14/17.
 */

public class CRUDOffer {

    public interface View extends DialogBase.View {

    }

    public interface Presenter extends DialogBase.Presenter {
        void save(Offer offer);
    }

}

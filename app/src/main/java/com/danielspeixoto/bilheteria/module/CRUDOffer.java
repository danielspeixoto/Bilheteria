package com.danielspeixoto.bilheteria.module;

import com.danielspeixoto.bilheteria.model.pojo.Offer;

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

package com.danielspeixoto.ticket.module;

/**
 * Created by danielspeixoto on 2/20/17.
 */

public class ToggleOffer {

    public interface View extends ActivityBase.View {

    }

    public interface Presenter extends ActivityBase.Presenter {

        void update(String UID, boolean isActivated);

    }

}

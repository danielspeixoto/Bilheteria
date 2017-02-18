package com.danielspeixoto.bilheteria.module;

import com.danielspeixoto.bilheteria.model.pojo.Ticket;

/**
 * Created by danielspeixoto on 2/18/17.
 */

public class InsertTicket {

    public interface View extends ActivityBase.View {
        void clear();
    }

    public interface Presenter extends ActivityBase.Presenter {
        void insert(Ticket ticket);
    }
}

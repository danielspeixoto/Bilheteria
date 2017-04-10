package com.danielspeixoto.ticket.module;

import com.danielspeixoto.ticket.model.pojo.Ticket;

/**
 * Created by danielspeixoto on 2/18/17.
 */

public class InsertTicket {

    public interface View extends ActivityBase.View {
        void onResult(String message);
    }

    public interface Presenter extends ActivityBase.Presenter {
        void insert(Ticket ticket);
    }
}

package com.danielspeixoto.ticket.module;

import com.danielspeixoto.ticket.model.pojo.Ticket;

/**
 * Created by danielspeixoto on 2/21/17.
 */

public class SearchTicket {

    public interface View extends Source.View<Ticket> {

    }

    public interface Presenter extends Source.Presenter {

        void setQuery(String query);

    }
}

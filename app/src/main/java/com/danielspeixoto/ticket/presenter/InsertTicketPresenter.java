package com.danielspeixoto.ticket.presenter;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.model.CRUDTickets;
import com.danielspeixoto.ticket.model.Connection;
import com.danielspeixoto.ticket.model.pojo.Ticket;
import com.danielspeixoto.ticket.module.InsertTicket;

import java.sql.Timestamp;


/**
 * Created by danielspeixoto on 2/18/17.
 */

public class InsertTicketPresenter implements InsertTicket.Presenter {

    private InsertTicket.View mView;

    public InsertTicketPresenter(InsertTicket.View view) {
        mView = view;
    }

    @Override
    public void insert(Ticket ticket) {
        ticket.setTimestamp(new Timestamp(System.currentTimeMillis()).getTime());
        ticket.setSeller(Connection.getCurrentUser().getName());
        CRUDTickets.insertTicket(ticket);
        mView.onResult(App.getStringResource(R.string.ticket_added));
    }
}

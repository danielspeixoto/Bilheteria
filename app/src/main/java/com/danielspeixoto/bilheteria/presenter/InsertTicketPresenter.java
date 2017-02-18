package com.danielspeixoto.bilheteria.presenter;

import com.danielspeixoto.bilheteria.helper.App;
import com.danielspeixoto.bilheteria.model.CRUDTickets;
import com.danielspeixoto.bilheteria.model.Connection;
import com.danielspeixoto.bilheteria.model.pojo.Ticket;
import com.danielspeixoto.bilheteria.module.InsertTicket;

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
        App.showMessage("Ticket created successfully");
        mView.clear();
    }
}

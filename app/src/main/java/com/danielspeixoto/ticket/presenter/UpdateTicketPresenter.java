package com.danielspeixoto.ticket.presenter;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.model.CRUDTickets;
import com.danielspeixoto.ticket.model.pojo.Ticket;
import com.danielspeixoto.ticket.module.UpdateTicket;

/**
 * Created by danielspeixoto on 4/11/17.
 */

public class UpdateTicketPresenter implements UpdateTicket.Presenter {
	
	private UpdateTicket.View mView;
	
	public UpdateTicketPresenter(UpdateTicket.View view) {
		mView = view;
	}
	
	
	@Override
	public void save(Ticket ticket) {
		CRUDTickets.update(ticket);
		mView.onSaveSuccess();
		App.showMessage(App.getStringResource(R.string.ticket_updated));
	}
}

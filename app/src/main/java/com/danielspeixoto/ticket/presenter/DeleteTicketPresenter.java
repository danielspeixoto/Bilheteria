package com.danielspeixoto.ticket.presenter;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.model.CRUDTickets;
import com.danielspeixoto.ticket.model.pojo.Ticket;
import com.danielspeixoto.ticket.module.DeleteTicket;

/**
 * Created by danielspeixoto on 4/11/17.
 */

public class DeleteTicketPresenter implements DeleteTicket.Presenter {
	
	private DeleteTicket.View mView;
	
	public DeleteTicketPresenter(DeleteTicket.View view) {
		mView = view;
	}
	
	@Override
	public void delete(Ticket ticket) {
		CRUDTickets.delete(ticket.getUid());
		mView.getActivity().showMessage(App.getStringResource(R.string.ticket_deleted));
		mView.onDeleted();
	}
}
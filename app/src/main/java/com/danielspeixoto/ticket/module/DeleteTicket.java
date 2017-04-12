package com.danielspeixoto.ticket.module;

import com.danielspeixoto.ticket.model.pojo.Ticket;

/**
 * Created by danielspeixoto on 4/11/17.
 */

public class DeleteTicket {
	
	public interface View extends ActivityBase.View {
		void onDeleted();
	}
	
	public interface Presenter extends ActivityBase.Presenter {
		void delete(Ticket ticket);
	}
}

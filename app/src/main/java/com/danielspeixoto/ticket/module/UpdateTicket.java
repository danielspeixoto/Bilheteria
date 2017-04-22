package com.danielspeixoto.ticket.module;

import com.danielspeixoto.ticket.model.pojo.Ticket;

/**
 * Created by danielspeixoto on 4/11/17.
 */

public class UpdateTicket {
	
	public interface View extends ActivityBase.View {
		void onSaveSuccess();
	}
	
	public interface Presenter extends ActivityBase.Presenter {
		void save(Ticket ticket);
	}
	
}

package com.danielspeixoto.ticket.module;

import com.danielspeixoto.ticket.model.pojo.User;

/**
 * Created by danielspeixoto on 4/11/17.
 */

public class DeleteUser {
	
	public interface View extends ActivityBase.View {
		void onDeleted();
	}
	
	public interface Presenter extends ActivityBase.Presenter {
		void delete(User user);
	}
}

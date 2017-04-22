package com.danielspeixoto.ticket.module;

import com.danielspeixoto.ticket.model.pojo.User;

/**
 * Created by danielspeixoto on 4/11/17.
 */

public class UpdateUser {
	
	public interface View extends ActivityBase.View {
	}
	
	public interface Presenter extends ActivityBase.Presenter {
		void save(User user);
	}
}

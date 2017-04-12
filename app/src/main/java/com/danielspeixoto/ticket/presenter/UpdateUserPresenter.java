package com.danielspeixoto.ticket.presenter;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.model.CRUDUsers;
import com.danielspeixoto.ticket.model.pojo.User;
import com.danielspeixoto.ticket.module.UpdateUser;
import com.danielspeixoto.ticket.util.Validate;

/**
 * Created by danielspeixoto on 4/11/17.
 */

public class UpdateUserPresenter implements UpdateUser.Presenter {
	
	private UpdateUser.View mView;
	
	public UpdateUserPresenter(UpdateUser.View view) {
		mView = view;
	}
	
	
	@Override
	public void save(User user) {
		String result = Validate.user(user);
		if (result.equals(Validate.OK)) {
			CRUDUsers.update(user);
			result = App.getStringResource(R.string.user_updated);
			mView.onSaveSuccess();
		}
		App.showMessage(result);
	}
}


package com.danielspeixoto.ticket.presenter;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.model.CRUDUsers;
import com.danielspeixoto.ticket.model.pojo.User;
import com.danielspeixoto.ticket.module.DeleteUser;

/**
 * Created by danielspeixoto on 4/11/17.
 */

public class DeleteUserPresenter implements DeleteUser.Presenter {
	
	private DeleteUser.View mView;
	
	public DeleteUserPresenter(DeleteUser.View view) {
		mView = view;
	}
	
	@Override
	public void delete(User user) {
		CRUDUsers.delete(user.getUsername());
		mView.getActivity().showMessage(App.getStringResource(R.string.user_deleted));
		mView.onDeleted();
	}
}
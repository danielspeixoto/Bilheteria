package com.danielspeixoto.ticket.view.activity;

import android.os.Bundle;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.model.pojo.User;
import com.danielspeixoto.ticket.module.UpdateUser;
import com.danielspeixoto.ticket.presenter.UpdateUserPresenter;

public class UpdateUserActivity extends UserDataActivity implements UpdateUser.View {
	
	private UpdateUser.Presenter mPresenter = new UpdateUserPresenter(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, R.layout.activity_update_user);
		activityInfo = App.getStringResource(R.string.info_update_user);
		mUser = getIntent().getParcelableExtra(User.class.getSimpleName());
		nameEdit.setText(mUser.getName());
		mAdapter.setPermissionsState(mUser.getPermissions());
	}
	
	@Override
	public void save() {
		super.save();
		mPresenter.save(mUser);
	}
	
	@Override
	public void onUpdated() {
		finish();
	}
}

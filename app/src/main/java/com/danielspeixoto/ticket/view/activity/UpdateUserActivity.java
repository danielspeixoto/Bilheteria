package com.danielspeixoto.ticket.view.activity;

import android.os.Bundle;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.model.pojo.User;
import com.danielspeixoto.ticket.module.UpdateUser;
import com.danielspeixoto.ticket.presenter.UpdateUserPresenter;

import butterknife.OnClick;

public class UpdateUserActivity extends UserDataActivity implements UpdateUser.View {
	
	private UpdateUser.Presenter mPresenter = new UpdateUserPresenter(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, R.layout.activity_update_user);
		activityInfo = App.getStringResource(R.string.info_update_user);
		mUser = getIntent().getParcelableExtra(User.class.getSimpleName());
		App.log(mUser.toString());
		mAdapter.setPermissionsState(mUser.getPermissions());
		nameEdit.setText(mUser.getName());
	}
	
	@Override
	public void save() {
		super.save();
		mPresenter.save(mUser);
	}
	
	@OnClick(R.id.changePassButton)
	public void changePass() {
		goToActivity(ChangePassActivity.class);
	}
	
	@Override
	public void onUpdated() {
		finish();
	}
}

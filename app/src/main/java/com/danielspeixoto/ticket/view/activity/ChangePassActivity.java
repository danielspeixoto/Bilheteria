package com.danielspeixoto.ticket.view.activity;

import android.os.Bundle;
import android.widget.EditText;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.model.Connection;
import com.danielspeixoto.ticket.model.pojo.User;
import com.danielspeixoto.ticket.module.UpdateUser;
import com.danielspeixoto.ticket.presenter.UpdateUserPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class ChangePassActivity extends BaseActivity implements UpdateUser.View {
	
	@BindView(R.id.oldPassEdit)
	EditText oldPassEdit;
	@BindView(R.id.passEdit)
	EditText passEdit;
	@BindView(R.id.confirmPassEdit)
	EditText confirmPassEdit;
	
	protected User mUser;
	
	private UpdateUser.Presenter mPresenter = new UpdateUserPresenter(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, R.layout.activity_change_pass);
		activityInfo = App.getStringResource(R.string.info_change_pass);
		mUser = Connection.getCurrentUser();
	}
	
	@OnClick(R.id.fab)
	public void save() {
		if(checkTextEmpty(oldPassEdit) || getText(oldPassEdit).equals(mUser.getPassword())) {
			oldPassEdit.requestFocus();
			showMessage(App.getStringResource(R.string.old_pass_must_match));
		}else if (checkTextEmpty(passEdit)) {
			passEdit.requestFocus();
			showMessage(getString(R.string.password_must_fill));
		} else if (!getText(passEdit).equals(getText(confirmPassEdit))) {
			confirmPassEdit.requestFocus();
			showMessage(getString(R.string.password_must_match));
		} else {
			mUser.setPassword(getText(passEdit));
			mPresenter.save(mUser);
		}
	}
}

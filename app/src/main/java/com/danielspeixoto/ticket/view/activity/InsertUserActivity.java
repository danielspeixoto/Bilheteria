package com.danielspeixoto.ticket.view.activity;

import android.os.Bundle;
import android.widget.EditText;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.module.InsertUser;
import com.danielspeixoto.ticket.presenter.InsertUserPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class InsertUserActivity extends UserDataActivity implements InsertUser.View {
	
	@BindView(R.id.passEdit)
	EditText passEdit;
	@BindView(R.id.confirmPassEdit)
	EditText confirmPassEdit;
	
	private InsertUser.Presenter mPresenter = new InsertUserPresenter(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, R.layout.activity_insert_user);
		activityInfo = getString(R.string.info_user_data);
	}
	
	@OnClick(R.id.fab)
	public void save() {
		super.save();
		if (checkTextEmpty(passEdit)) {
			passEdit.requestFocus();
			showMessage(getString(R.string.password_must_fill));
		} else if (!getText(passEdit).equals(getText(confirmPassEdit))) {
			confirmPassEdit.requestFocus();
			showMessage(getString(R.string.password_must_match));
		} else {
			mUser.setPassword(getText(passEdit));
			mPresenter.createUser(mUser);
		}
	}
	
}

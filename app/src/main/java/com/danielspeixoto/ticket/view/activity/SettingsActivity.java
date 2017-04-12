package com.danielspeixoto.ticket.view.activity;

import android.os.Bundle;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.model.Connection;
import com.danielspeixoto.ticket.model.pojo.Link;
import com.danielspeixoto.ticket.view.custom.RecyclerList;
import com.danielspeixoto.ticket.view.recycler.adapter.OptionsAdapter;

import butterknife.BindView;

public class SettingsActivity extends BaseActivity {
	
	@BindView(R.id.list)
	RecyclerList list;
	
	private OptionsAdapter mAdapter = new OptionsAdapter(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, R.layout.activity_settings);
		activityInfo = App.getStringResource(R.string.info_settings);
		list.setAdapter(mAdapter);
		mAdapter.addItem(new Link(App.getStringResource(R.string.change_password), () -> goToActivity(ChangePassActivity.class)));
		mAdapter.addItem(new Link(App.getStringResource(R.string.log_out), () -> {
			Connection.logOff();
			goToActivity(MainActivity.class);
			finish();
		}));
	}
	
}

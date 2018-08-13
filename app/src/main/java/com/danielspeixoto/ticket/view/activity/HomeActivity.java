package com.danielspeixoto.ticket.view.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
//import android.support.design.widget.FloatingActionButton;
import android.view.MenuItem;
import android.view.View;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.model.Connection;
import com.danielspeixoto.ticket.view.custom.RecyclerList;
import com.danielspeixoto.ticket.view.recycler.adapter.DrawerAdapter;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.drawer)
    RecyclerList drawer;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState, R.layout.activity_home);
        if (Connection.getCurrentUser().cannotSell()) {
            this.fab.setVisibility(View.GONE);
        }
        activityInfo = getString(R.string.info_home);
        drawer.setAdapter(new DrawerAdapter(HomeActivity.this));
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.accept, R.string.decline);
        drawerLayout.addDrawerListener(drawerToggle);
    }

    @OnClick(R.id.fab)
    public void createTicket() {
        goToActivity(TicketDataActivity.class);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return drawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

}

package com.danielspeixoto.ticket.view.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.model.Connection;
import com.danielspeixoto.ticket.view.recycler.adapter.DrawerAdapter;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.drawer)
    RecyclerView drawer;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_home);
        drawer.setAdapter(new DrawerAdapter(this));
        drawer.setLayoutManager(new LinearLayoutManager(this));
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.accept, R.string.decline);
        drawerLayout.addDrawerListener(drawerToggle);
    }

    @OnClick(R.id.fab)
    public void createTicket() {
        goToActivity(TicketDataActivity.class);
    }

    @OnClick(R.id.logOutButton)
    public void logOut() {
        Connection.logOff();
        goToActivity(MainActivity.class);
        finish();
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
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

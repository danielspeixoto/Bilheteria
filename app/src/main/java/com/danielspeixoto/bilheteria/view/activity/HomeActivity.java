package com.danielspeixoto.bilheteria.view.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.view.recycler.adapter.DrawerRecyclerAdapter;

import butterknife.BindView;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.drawer)
    RecyclerView drawer;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_home);
        drawer.setAdapter(new DrawerRecyclerAdapter(this));
        drawer.setLayoutManager(new LinearLayoutManager(this));
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.accept, R.string.decline);
        drawerLayout.addDrawerListener(drawerToggle);
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

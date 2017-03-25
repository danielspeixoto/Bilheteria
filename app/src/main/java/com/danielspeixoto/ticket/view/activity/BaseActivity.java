package com.danielspeixoto.ticket.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.module.ActivityBase;
import com.danielspeixoto.ticket.view.dialog.InfoDialog;

import butterknife.ButterKnife;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public abstract class BaseActivity extends AppCompatActivity implements ActivityBase.View {

    protected static final String EMPTY_STRING = "";
    public final String TAG = getClass().getSimpleName();
    protected String activityInfo;

    public void showMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    protected void onCreate(@Nullable Bundle savedInstanceState, int layout) {
        super.onCreate(savedInstanceState);
        setContentView(layout);
        activityInfo = getString(R.string.no_description);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.info_menu_item:
                InfoDialog infoDialog = new InfoDialog(this);
                infoDialog.setInfoText(activityInfo);
                infoDialog.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public BaseActivity getActivity() {
        return this;
    }

    public void goToActivity(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    protected boolean checkTextEmpty(EditText editText) {
        return editText.getText().toString().equals(EMPTY_STRING);
    }

    protected String getText(TextView text) {
        return text.getText().toString().trim();
    }

    protected void clear(EditText editText) {
        editText.setText(EMPTY_STRING);
    }
}

package com.danielspeixoto.bilheteria.view.activity;

import android.os.Bundle;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.presenter.InsertItemPresenter;
import com.danielspeixoto.bilheteria.view.dialog.ItemDialog;

import butterknife.OnClick;

public class ItemsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_items);
    }

    @OnClick(R.id.fab)
    public void createItem() {
        ItemDialog dialog = new ItemDialog(this);
        dialog.setMPresenter(new InsertItemPresenter(dialog));
        dialog.show();
    }

}

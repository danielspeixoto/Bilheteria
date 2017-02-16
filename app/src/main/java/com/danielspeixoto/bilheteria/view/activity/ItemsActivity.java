package com.danielspeixoto.bilheteria.view.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.presenter.AllItemsPresenter;
import com.danielspeixoto.bilheteria.presenter.InsertItemPresenter;
import com.danielspeixoto.bilheteria.view.dialog.ItemDialog;
import com.danielspeixoto.bilheteria.view.recycler.adapter.ItemsRecyclerAdapter;

import butterknife.BindView;
import butterknife.OnClick;

public class ItemsActivity extends BaseActivity {

    @BindView(R.id.list)
    RecyclerView list;

    private ItemsRecyclerAdapter mAdapter = new ItemsRecyclerAdapter<>(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_items);
        mAdapter.setPresenter(new AllItemsPresenter(mAdapter));
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(mAdapter);
    }

    @OnClick(R.id.fab)
    public void createItem() {
        ItemDialog dialog = new ItemDialog(this);
        dialog.setMPresenter(new InsertItemPresenter(dialog));
        dialog.show();
    }

}

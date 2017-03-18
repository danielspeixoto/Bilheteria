package com.danielspeixoto.ticket.view.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.presenter.AllOffersPresenter;
import com.danielspeixoto.ticket.presenter.InsertOfferPresenter;
import com.danielspeixoto.ticket.view.dialog.OfferDialog;
import com.danielspeixoto.ticket.view.recycler.adapter.OffersShowAdapter;

import butterknife.BindView;
import butterknife.OnClick;

public class OffersActivity extends BaseActivity {

    @BindView(R.id.list)
    RecyclerView list;

    private OffersShowAdapter mAdapter = new OffersShowAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_items);
        mAdapter.setPresenter(new AllOffersPresenter(mAdapter));
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(mAdapter);
    }

    @OnClick(R.id.fab)
    public void createItem() {
        OfferDialog dialog = new OfferDialog(this);
        dialog.setMPresenter(new InsertOfferPresenter(dialog));
        dialog.show();
    }

}
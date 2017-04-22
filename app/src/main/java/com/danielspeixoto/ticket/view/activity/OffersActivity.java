package com.danielspeixoto.ticket.view.activity;

import android.os.Bundle;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.module.InsertOffer;
import com.danielspeixoto.ticket.presenter.AllOffersPresenter;
import com.danielspeixoto.ticket.presenter.InsertOfferPresenter;
import com.danielspeixoto.ticket.view.custom.RecyclerList;
import com.danielspeixoto.ticket.view.dialog.OfferDialog;
import com.danielspeixoto.ticket.view.recycler.adapter.OffersShowAdapter;

import butterknife.BindView;
import butterknife.OnClick;

public class OffersActivity extends BaseActivity implements InsertOffer.View {

    @BindView(R.id.list)
    RecyclerList list;
    private OfferDialog dialog;

    private OffersShowAdapter mAdapter = new OffersShowAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_items);
        activityInfo = getString(R.string.info_offers);
        mAdapter.setPresenter(new AllOffersPresenter(mAdapter));
        list.setAdapter(mAdapter);
    }

    @OnClick(R.id.fab)
    public void createItem() {
        dialog = new OfferDialog(this);
        dialog.setMPresenter(new InsertOfferPresenter(OffersActivity.this));
        dialog.show();
    }

    @Override
    public void onSaveSuccess() {
        dialog.dismiss();
    }
}

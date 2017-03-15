package com.danielspeixoto.ticket.view.recycler.holder;

import android.view.View;
import android.widget.Switch;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.module.ToggleOffer;
import com.danielspeixoto.ticket.presenter.ToggleOfferPresenter;
import com.danielspeixoto.ticket.view.recycler.adapter.OffersShowAdapter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by danielspeixoto on 2/20/17.
 */

public class OfferShowHolder extends OfferHolder<OffersShowAdapter> implements ToggleOffer.View {

    private static ToggleOffer.Presenter mPresenter;
    @BindView(R.id.switchActivated)
    Switch switchActivated;

    public OfferShowHolder(View itemView, OffersShowAdapter mAdapter) {
        super(itemView, mAdapter);
        mPresenter = new ToggleOfferPresenter(this);
    }

    @Override
    public void onPostCreated() {
        super.onPostCreated();
        if (mItem.isActivated() && !switchActivated.isChecked()) {
            switchActivated.toggle();
        }
    }

    @OnClick(R.id.switchActivated)
    public void toggleActivated() {
        mItem.toggleActivated();
        mPresenter.update(mItem.getUid(), mItem.isActivated());
    }
}

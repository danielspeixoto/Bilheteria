package com.danielspeixoto.bilheteria.view.recycler.holder;

import android.view.View;
import android.widget.Switch;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.module.ToggleOffer;
import com.danielspeixoto.bilheteria.presenter.ToggleOfferPresenter;
import com.danielspeixoto.bilheteria.view.recycler.adapter.OffersShowAdapter;

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
        if (mItem.isActivated()) {
            switchActivated.toggle();
        }
    }

    @OnClick(R.id.switchActivated)
    public void toggleActivated() {
        mItem.toggleActivated();
        mPresenter.update(mItem.getUid(), mItem.isActivated());
    }
}

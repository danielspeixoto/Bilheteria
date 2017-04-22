package com.danielspeixoto.ticket.view.recycler.holder;

import android.view.View;
import android.widget.Switch;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.model.pojo.Link;
import com.danielspeixoto.ticket.module.DeleteOffer;
import com.danielspeixoto.ticket.module.ToggleOffer;
import com.danielspeixoto.ticket.module.UpdateOffer;
import com.danielspeixoto.ticket.presenter.DeleteOfferPresenter;
import com.danielspeixoto.ticket.presenter.ToggleOfferPresenter;
import com.danielspeixoto.ticket.presenter.UpdateOfferPresenter;
import com.danielspeixoto.ticket.view.dialog.AreYouSureDialog;
import com.danielspeixoto.ticket.view.dialog.OfferDialog;
import com.danielspeixoto.ticket.view.dialog.OptionsDialog;
import com.danielspeixoto.ticket.view.recycler.adapter.OffersShowAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by danielspeixoto on 2/20/17.
 */

public class OfferShowHolder extends OfferHolder<OffersShowAdapter> implements ToggleOffer.View,
        DeleteOffer.View, UpdateOffer.View {

    private static ToggleOffer.Presenter mPresenter;
    @BindView(R.id.switchActivated)
    Switch switchActivated;
	private OptionsDialog dialog;

    public OfferShowHolder(View itemView, OffersShowAdapter mAdapter) {
        super(itemView, mAdapter);
        mPresenter = new ToggleOfferPresenter(this);
        dialog = new OptionsDialog(getActivity());
        ArrayList<Link> links = new ArrayList<>();
        // EDIT OFFER
        links.add(new Link(App.getStringResource(R.string.edit), () -> {
            OfferDialog offerDialog = new OfferDialog(getActivity());
            offerDialog.setOffer(mItem);
            offerDialog.setMPresenter(new UpdateOfferPresenter(OfferShowHolder.this));
            offerDialog.show();
            dialog.dismiss();
        }));
        // DELETE OFFER
        links.add(new Link(App.getStringResource(R.string.delete), () -> {
            AreYouSureDialog areYouSureDialog = new AreYouSureDialog();
            areYouSureDialog.setMOnYesClicked(() -> new DeleteOfferPresenter(OfferShowHolder.this).delete(mItem));
            areYouSureDialog.show(getActivity().getSupportFragmentManager(), AreYouSureDialog.TAG);
            dialog.dismiss();
        }));
        dialog.setLinks(links);
    }
	
	@OnClick(R.id.item)
	public void onItemClicked() {
		dialog.show();
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

    @Override
    public void onDeleted() {
        mAdapter.getItems();
    }

    @Override
    public void onSaveSuccess() {
        mAdapter.getItems();
    }

}

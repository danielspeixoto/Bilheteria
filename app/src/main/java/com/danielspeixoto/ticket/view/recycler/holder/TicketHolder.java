package com.danielspeixoto.ticket.view.recycler.holder;

import android.view.View;
import android.widget.TextView;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.model.pojo.Link;
import com.danielspeixoto.ticket.model.pojo.Ticket;
import com.danielspeixoto.ticket.module.DeleteTicket;
import com.danielspeixoto.ticket.presenter.DeleteTicketPresenter;
import com.danielspeixoto.ticket.view.dialog.AreYouSureDialog;
import com.danielspeixoto.ticket.view.dialog.OptionsDialog;
import com.danielspeixoto.ticket.view.recycler.adapter.TicketsAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by danielspeixoto on 2/21/17.
 */

public class TicketHolder extends BaseHolder<TicketsAdapter, Ticket> implements DeleteTicket.View {
 
	@BindView(R.id.nameText)
    TextView nameText;
    @BindView(R.id.priceText)
    TextView priceText;
	private OptionsDialog dialog;
	
	public TicketHolder(View itemView, TicketsAdapter mAdapter) {
		super(itemView, mAdapter);
		dialog = new OptionsDialog(getActivity());
		ArrayList<Link> links = new ArrayList<>();
		// DELETE TICKET
		links.add(new Link(App.getStringResource(R.string.delete), () -> {
			AreYouSureDialog areYouSureDialog = new AreYouSureDialog(() -> new DeleteTicketPresenter(TicketHolder.this).delete(mItem));
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
	public void onDeleted() {
		mAdapter.getItems();
	}
	

    @Override
    public void onPostCreated() {
        nameText.setText(mItem.getIdentification());
        priceText.setText("$" + mItem.getPrice());
    }
}

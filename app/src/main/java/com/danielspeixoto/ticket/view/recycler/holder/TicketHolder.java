package com.danielspeixoto.ticket.view.recycler.holder;

import android.support.v7.widget.CardView;
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

/**
 * Created by danielspeixoto on 2/21/17.
 */

public class TicketHolder extends BaseHolder<TicketsAdapter, Ticket> implements DeleteTicket.View {
 
	@BindView(R.id.nameText)
    TextView nameText;
    @BindView(R.id.priceText)
    TextView priceText;
    @BindView(R.id.cardItem)
    CardView cardItem;
    
	public TicketHolder(View itemView, TicketsAdapter mAdapter) {
		super(itemView, mAdapter);
		OptionsDialog dialog = new OptionsDialog(getActivity());
		ArrayList<Link> links = new ArrayList<>();
		// DELETE TICKET
		links.add(new Link(App.getStringResource(R.string.delete), () -> {
			AreYouSureDialog areYouSureDialog = new AreYouSureDialog(() -> new DeleteTicketPresenter(TicketHolder.this).delete(mItem));
			areYouSureDialog.show(getActivity().getSupportFragmentManager(), AreYouSureDialog.TAG);
			dialog.dismiss();
		}));
		dialog.setLinks(links);
		cardItem.setOnLongClickListener((l) -> {
			dialog.show();
			return true;
		});
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

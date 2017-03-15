package com.danielspeixoto.ticket.view.recycler.holder;

import android.view.View;
import android.widget.TextView;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.model.pojo.Ticket;
import com.danielspeixoto.ticket.view.recycler.adapter.TicketsAdapter;

import butterknife.BindView;

/**
 * Created by danielspeixoto on 2/21/17.
 */

public class TicketHolder extends BaseHolder<TicketsAdapter, Ticket> {

    @BindView(R.id.nameText)
    TextView nameText;
    @BindView(R.id.priceText)
    TextView priceText;

    public TicketHolder(View itemView, TicketsAdapter mAdapter) {
        super(itemView, mAdapter);
    }

    @Override
    public void onPostCreated() {
        nameText.setText(mItem.getIdentification());
        priceText.setText("$" + mItem.getPrice());
    }
}

package com.danielspeixoto.ticket.view.recycler.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.model.pojo.Ticket;
import com.danielspeixoto.ticket.module.Source;
import com.danielspeixoto.ticket.view.activity.BaseActivity;
import com.danielspeixoto.ticket.view.recycler.holder.TicketHolder;

/**
 * Created by danielspeixoto on 2/21/17.
 */

public abstract class TicketsAdapter<P extends Source.Presenter> extends SourceAdapter<Ticket, TicketHolder, P> {

    public TicketsAdapter(BaseActivity activity) {
        super(activity);
    }


    @Override
    public void reset() {
        data.clear();
    }

    @Override
    public TicketHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TicketHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_ticket, parent, false), this);
    }


}

package com.danielspeixoto.bilheteria.view.recycler.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.model.pojo.Ticket;
import com.danielspeixoto.bilheteria.module.Source;
import com.danielspeixoto.bilheteria.view.activity.BaseActivity;
import com.danielspeixoto.bilheteria.view.recycler.holder.TicketHolder;

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

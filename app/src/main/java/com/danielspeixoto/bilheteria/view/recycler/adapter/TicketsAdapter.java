package com.danielspeixoto.bilheteria.view.recycler.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.model.pojo.Ticket;
import com.danielspeixoto.bilheteria.module.OnItemChanged;
import com.danielspeixoto.bilheteria.module.TicketsInPeriod;
import com.danielspeixoto.bilheteria.presenter.TicketsInPeriodPresenter;
import com.danielspeixoto.bilheteria.view.activity.BaseActivity;
import com.danielspeixoto.bilheteria.view.recycler.holder.TicketHolder;

import lombok.Setter;

/**
 * Created by danielspeixoto on 2/21/17.
 */

public class TicketsAdapter extends SourceAdapter<Ticket, TicketHolder> implements TicketsInPeriod.View {

    @Setter
    private OnItemChanged<Double> mOnItemChanged;

    public TicketsAdapter(BaseActivity activity) {
        super(activity);
    }

    public void setDates(String start, String end) {
        ((TicketsInPeriodPresenter) presenter).setDates(start, end);
        getItems();
    }

    @Override
    public void reset() {
        data.clear();
    }

    @Override
    public void setAmount(double amount) {
        if (mOnItemChanged != null) {
            mOnItemChanged.onItemChanged(amount);
        }
    }

    @Override
    public TicketHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TicketHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_ticket, parent, false), this);
    }


}

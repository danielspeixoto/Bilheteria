package com.danielspeixoto.bilheteria.view.recycler.adapter;

import com.danielspeixoto.bilheteria.module.OnItemChanged;
import com.danielspeixoto.bilheteria.module.TicketsInPeriod;
import com.danielspeixoto.bilheteria.presenter.TicketsInPeriodPresenter;
import com.danielspeixoto.bilheteria.view.activity.BaseActivity;

import lombok.Setter;

/**
 * Created by danielspeixoto on 2/21/17.
 */

public class TicketsInPeriodAdapter extends TicketsAdapter<TicketsInPeriodPresenter> implements TicketsInPeriod.View {

    @Setter
    private OnItemChanged<Double> mOnItemChanged;

    public TicketsInPeriodAdapter(BaseActivity activity) {
        super(activity);
    }

    public void setDates(String start, String end) {
        presenter.setDates(start, end);
        getItems();
    }


    @Override
    public void setAmount(double amount) {
        if (mOnItemChanged != null) {
            mOnItemChanged.onItemChanged(amount);
        }
    }
}

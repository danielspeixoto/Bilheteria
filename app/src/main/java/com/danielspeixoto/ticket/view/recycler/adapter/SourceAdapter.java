package com.danielspeixoto.ticket.view.recycler.adapter;

import com.danielspeixoto.ticket.module.Source;
import com.danielspeixoto.ticket.view.activity.BaseActivity;
import com.danielspeixoto.ticket.view.recycler.holder.BaseHolder;

/**
 * Created by danielspeixoto on 2/15/17.
 */

public abstract class SourceAdapter<T, S extends BaseHolder<? extends SourceAdapter, T>, P extends Source.Presenter>
        extends BaseAdapter<T, S>
        implements Source.View<T> {

    protected P presenter;

    public SourceAdapter(BaseActivity activity) {
        super(activity);
    }

    public void setPresenter(P presenter) {
        this.presenter = presenter;
        getItems();
    }

    @Override
    public void getItems() {
        presenter.syncItems();
        notifyDataSetChanged();
    }

    public abstract void reset();
}

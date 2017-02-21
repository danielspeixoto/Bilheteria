package com.danielspeixoto.bilheteria.view.recycler.adapter;

import com.danielspeixoto.bilheteria.module.Source;
import com.danielspeixoto.bilheteria.view.activity.BaseActivity;
import com.danielspeixoto.bilheteria.view.recycler.holder.BaseHolder;

/**
 * Created by danielspeixoto on 2/15/17.
 */

public abstract class SourceAdapter<T, S extends BaseHolder<? extends SourceAdapter, T>>
        extends BaseAdapter<T, S>
        implements Source.View<T> {

    protected Source.Presenter presenter;

    public SourceAdapter(BaseActivity activity) {
        super(activity);
    }

    public void setPresenter(Source.Presenter presenter) {
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

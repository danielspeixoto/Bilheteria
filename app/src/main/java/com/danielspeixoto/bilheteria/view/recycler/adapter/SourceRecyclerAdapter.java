package com.danielspeixoto.bilheteria.view.recycler.adapter;

import com.danielspeixoto.bilheteria.module.Source;
import com.danielspeixoto.bilheteria.view.activity.BaseActivity;

import lombok.Setter;

/**
 * Created by danielspeixoto on 2/15/17.
 */

public abstract class SourceRecyclerAdapter<T> extends BaseRecyclerAdapter<T> implements Source.View<T> {

    @Setter
    private Source.Presenter presenter;

    public SourceRecyclerAdapter(BaseActivity activity) {
        super(activity);
    }

    public void setPresenter(Source.Presenter presenter) {
        this.presenter = presenter;
        getItems();
    }

    @Override
    public void getItems() {
        presenter.getItems();
        notifyDataSetChanged();
    }
}

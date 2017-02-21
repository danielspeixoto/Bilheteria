package com.danielspeixoto.bilheteria.view.recycler.adapter;

import com.danielspeixoto.bilheteria.module.SearchTicket;
import com.danielspeixoto.bilheteria.view.activity.BaseActivity;

/**
 * Created by danielspeixoto on 2/21/17.;
 */

public class SearchTicketsAdapter extends TicketsAdapter<SearchTicket.Presenter> implements SearchTicket.View {

    private String query;

    public SearchTicketsAdapter(BaseActivity activity) {
        super(activity);
    }

    public void setQuery(String query) {
        this.query = query;
        reset();
        presenter.setQuery(query);
        presenter.syncItems();
    }

    @Override
    public void setPresenter(SearchTicket.Presenter presenter) {
        this.presenter = presenter;
        if (query != null) {
            getItems();
        }
    }
}

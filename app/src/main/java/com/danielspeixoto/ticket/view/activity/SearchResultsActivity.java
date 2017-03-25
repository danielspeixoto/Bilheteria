package com.danielspeixoto.ticket.view.activity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.presenter.SearchTicketPresenter;
import com.danielspeixoto.ticket.view.recycler.adapter.SearchTicketsAdapter;

import butterknife.BindView;

public class SearchResultsActivity extends BaseActivity {

    @BindView(R.id.list)
    RecyclerView list;

    private SearchTicketsAdapter mAdapter = new SearchTicketsAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_search_results);
        activityInfo = getString(R.string.info_search_results);
        mAdapter.setPresenter(new SearchTicketPresenter(mAdapter));
        handleIntent(getIntent());
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(mAdapter);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
//        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            mAdapter.setQuery(intent.getStringExtra(SearchManager.QUERY));
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.search_menu, menu);
//        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
//        return true;
//    }

}

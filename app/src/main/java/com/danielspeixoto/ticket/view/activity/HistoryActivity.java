package com.danielspeixoto.ticket.view.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.widget.TextView;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.presenter.TicketsInPeriodPresenter;
import com.danielspeixoto.ticket.view.custom.PickDateView;
import com.danielspeixoto.ticket.view.recycler.adapter.TicketsInPeriodAdapter;

import butterknife.BindView;

public class HistoryActivity extends BaseActivity {

    @BindView(R.id.list)
    RecyclerView list;
    @BindView(R.id.pickDate)
    PickDateView pickDate;
    @BindView(R.id.amountText)
    TextView amountText;

    private TicketsInPeriodAdapter mAdapter = new TicketsInPeriodAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_history);
        mAdapter.setPresenter(new TicketsInPeriodPresenter(mAdapter));
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(mAdapter);
        list.setNestedScrollingEnabled(false);
        pickDate.setOnPeriodChangedListener(() -> mAdapter.setDates(pickDate.getStartDate(), pickDate.getEndDate()));
        mAdapter.setMOnItemChanged(valueChanged -> amountText.setText("$" + valueChanged));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.search_menu, menu);
//        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        return true;
    }
}

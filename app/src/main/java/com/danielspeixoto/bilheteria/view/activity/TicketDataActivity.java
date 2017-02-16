package com.danielspeixoto.bilheteria.view.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.TextView;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.helper.FloatCallback;
import com.danielspeixoto.bilheteria.presenter.AllItemsPresenter;
import com.danielspeixoto.bilheteria.view.recycler.adapter.ItemsBuyRecyclerAdapter;
import com.danielspeixoto.bilheteria.view.recycler.adapter.PaymentsRecyclerAdapter;

import butterknife.BindView;

public class TicketDataActivity extends BaseActivity {

    @BindView(R.id.idEdit)
    EditText idEdit;
    @BindView(R.id.observationsEdit)
    EditText observationsEdit;
    @BindView(R.id.itemsList)
    RecyclerView itemsList;
    @BindView(R.id.priceText)
    TextView priceText;
    @BindView(R.id.paymentsList)
    RecyclerView paymentsList;

    private ItemsBuyRecyclerAdapter mItemsAdapter = new ItemsBuyRecyclerAdapter(this, new FloatCallback() {
        @Override
        public void run(float value) {
            priceText.setText("$" + (Float.valueOf(priceText.getText().toString().substring(1)) + value));
        }
    });
    private PaymentsRecyclerAdapter mPaymentsAdapter = new PaymentsRecyclerAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_ticket_data);
        mItemsAdapter.setPresenter(new AllItemsPresenter(mItemsAdapter));
        itemsList.setLayoutManager(new LinearLayoutManager(this));
        itemsList.setAdapter(mItemsAdapter);
        paymentsList.setLayoutManager(new LinearLayoutManager(this));
    }

}

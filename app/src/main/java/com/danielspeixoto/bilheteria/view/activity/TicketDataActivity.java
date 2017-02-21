package com.danielspeixoto.bilheteria.view.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.TextView;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.model.pojo.Ticket;
import com.danielspeixoto.bilheteria.module.InsertTicket;
import com.danielspeixoto.bilheteria.module.OnItemChanged;
import com.danielspeixoto.bilheteria.presenter.ActivatedOffersPresenter;
import com.danielspeixoto.bilheteria.presenter.AllPaymentsPresenter;
import com.danielspeixoto.bilheteria.presenter.InsertTicketPresenter;
import com.danielspeixoto.bilheteria.view.recycler.adapter.OffersBuyAdapter;
import com.danielspeixoto.bilheteria.view.recycler.adapter.PaymentsBuyAdapter;
import com.danielspeixoto.bilheteria.view.recycler.adapter.SourceAdapter;

import butterknife.BindView;
import butterknife.OnClick;

public class TicketDataActivity extends BaseActivity implements InsertTicket.View, OnItemChanged<Float> {

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

    private InsertTicket.Presenter mPresenter;
    private Ticket ticket = new Ticket();

    private OffersBuyAdapter mOffersAdapter = new OffersBuyAdapter(this, this);
    private PaymentsBuyAdapter mPaymentsAdapter = new PaymentsBuyAdapter(this, this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_ticket_data);
        mOffersAdapter.setPresenter(new ActivatedOffersPresenter(mOffersAdapter));
        itemsList.setLayoutManager(new LinearLayoutManager(this));
        itemsList.setNestedScrollingEnabled(false);
        itemsList.setAdapter(mOffersAdapter);
        mPaymentsAdapter.setPresenter(new AllPaymentsPresenter(mPaymentsAdapter));
        paymentsList.setLayoutManager(new LinearLayoutManager(this));
        paymentsList.setNestedScrollingEnabled(false);
        paymentsList.setAdapter(mPaymentsAdapter);
        mPresenter = new InsertTicketPresenter(this);
    }

    @OnClick(R.id.saveButton)
    public void save() {
        if (!getText(priceText).equals("$0.0")) {
            showMessage("Payment is not completed");
        } else {
            ticket.setIdentification(getText(idEdit));
            ticket.setObservations(getText(observationsEdit));
            ticket.setOffers(mOffersAdapter.getNotZero());
            ticket.setPayments(mPaymentsAdapter.getNotZero());
            mPresenter.insert(ticket);
        }
    }

    @Override
    public void clear() {
        clear(idEdit);
        clear(observationsEdit);
        idEdit.requestFocus();
        clear(mOffersAdapter);
        clear(mPaymentsAdapter);
        priceText.setText("$0.0");
    }

    public void clear(SourceAdapter adapter) {
        adapter.reset();
    }

    @Override
    public void onItemChanged(Float valueChanged) {
        priceText.setText("$" + (Float.valueOf(priceText.getText().toString().substring(1)) + valueChanged));

    }
}

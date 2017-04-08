package com.danielspeixoto.ticket.view.activity;

import android.os.Bundle;
import android.widget.EditText;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.model.pojo.Payment;
import com.danielspeixoto.ticket.module.InsertPayment;
import com.danielspeixoto.ticket.presenter.AllPaymentsPresenter;
import com.danielspeixoto.ticket.presenter.InsertPaymentPresenter;
import com.danielspeixoto.ticket.view.custom.RecyclerList;
import com.danielspeixoto.ticket.view.recycler.adapter.PaymentsShowAdapter;

import butterknife.BindView;
import butterknife.OnClick;

public class PaymentsActivity extends BaseActivity implements InsertPayment.View {

    @BindView(R.id.nameEdit)
    EditText nameEdit;
    @BindView(R.id.list)
    RecyclerList list;

    private PaymentsShowAdapter mAdapter = new PaymentsShowAdapter(this);
    private InsertPayment.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_payments);
        activityInfo = getString(R.string.info_payments);
        mAdapter.setPresenter(new AllPaymentsPresenter(mAdapter));
        list.setAdapter(mAdapter);
        mPresenter = new InsertPaymentPresenter(this);
    }

    @OnClick(R.id.addButton)
    public void createPayment() {
        mPresenter.insert(new Payment(getText(nameEdit)));
    }

    @Override
    public void clear() {
        nameEdit.setText(EMPTY_STRING);
    }
}

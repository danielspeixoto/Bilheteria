package com.danielspeixoto.bilheteria.view.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.model.pojo.Payment;
import com.danielspeixoto.bilheteria.module.InsertPayment;
import com.danielspeixoto.bilheteria.presenter.AllPaymentsPresenter;
import com.danielspeixoto.bilheteria.presenter.InsertPaymentPresenter;
import com.danielspeixoto.bilheteria.view.recycler.adapter.PaymentsShowAdapter;

import butterknife.BindView;
import butterknife.OnClick;

public class PaymentsActivity extends BaseActivity implements InsertPayment.View {

    @BindView(R.id.nameEdit)
    EditText nameEdit;
    @BindView(R.id.list)
    RecyclerView list;

    private PaymentsShowAdapter mAdapter = new PaymentsShowAdapter(this);
    private InsertPayment.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_payments);
        mAdapter.setPresenter(new AllPaymentsPresenter(mAdapter));
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(mAdapter);
        mPresenter = new InsertPaymentPresenter(this);
    }

    @OnClick(R.id.addButton)
    public void createPayment() {
        mPresenter.insert(new Payment(nameEdit.getText().toString()));
    }

    @Override
    public void clear() {
        nameEdit.setText(EMPTY_STRING);
    }
}

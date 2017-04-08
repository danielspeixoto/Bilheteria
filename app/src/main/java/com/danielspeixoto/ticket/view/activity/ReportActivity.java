package com.danielspeixoto.ticket.view.activity;

import android.os.Bundle;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.model.Report;
import com.danielspeixoto.ticket.module.Reports;
import com.danielspeixoto.ticket.presenter.ReportPresenter;
import com.danielspeixoto.ticket.view.custom.PickDateView;
import com.danielspeixoto.ticket.view.custom.RecyclerList;
import com.danielspeixoto.ticket.view.recycler.adapter.OffersReportAdapter;
import com.danielspeixoto.ticket.view.recycler.adapter.PaymentsReportAdapter;

import butterknife.BindView;

public class ReportActivity extends BaseActivity implements Reports.View {
    
    @BindView(R.id.pickDate)
    PickDateView pickDate;
    @BindView(R.id.paymentsList)
    RecyclerList paymentsList;
    @BindView(R.id.offersList)
    RecyclerList offersList;
    
    private PaymentsReportAdapter paymentAdapter = new PaymentsReportAdapter(this);
    private OffersReportAdapter offerAdapter = new OffersReportAdapter(this);
    private Reports.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_report);
        activityInfo = getString(R.string.info_report);
        mPresenter = new ReportPresenter(this);
        // Load today's report
        mPresenter.getItems();
        pickDate.setOnPeriodChangedListener(() -> mPresenter.setDates(pickDate.getStartDate(), pickDate.getEndDate()));
        paymentsList.setAdapter(paymentAdapter);
        paymentsList.setNestedScrollEnabled(false);
        offersList.setAdapter(offerAdapter);
        offersList.setNestedScrollEnabled(false);
    }
    
    @Override
    public void setReport(Report report) {
        paymentAdapter.setMReport(report);
        offerAdapter.setMReport(report);
    }
}

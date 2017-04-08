package com.danielspeixoto.ticket.presenter;

import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.helper.Time;
import com.danielspeixoto.ticket.model.CRUDTickets;
import com.danielspeixoto.ticket.model.Report;
import com.danielspeixoto.ticket.model.pojo.Payment;
import com.danielspeixoto.ticket.model.pojo.Ticket;
import com.danielspeixoto.ticket.module.Reports;

import rx.Subscriber;

/**
 * Created by danielspeixoto on 2/21/17.
 */

public class ReportPresenter implements Reports.Presenter {

    private static float price;
    private static double total = 0;
    private static Report mReport = new Report();
    private Reports.View mView;
    private String startDate = Time.getDate(), endDate = startDate;

    public ReportPresenter(Reports.View view) {
        mView = view;
    }

    @Override
    public void setDates(String start, String end) {
        startDate = start;
        endDate = end;
        mReport = new Report();
        mView.setReport(mReport);
        getItems();
    }
    
    public void getItems() {
        CRUDTickets.getInPeriod(Time.getMillis(startDate), Time.getMillis(endDate)).subscribe(new Subscriber<Ticket>() {
            @Override
            public void onCompleted() {
            
            }
        
            @Override
            public void onError(Throwable e) {
                App.showMessage(e.getMessage());
            }
        
            @Override
            public void onNext(Ticket ticket) {
                mReport.addTicket(ticket);
                mView.setReport(mReport);
                /**/
                // TODO Fix this(setting price) after corrections in users apps are made
                price = 0;
                for (Payment payment : ticket.getPayments()) {
                    price += payment.getAmount();
                }
                ticket.setPrice(price);
                CRUDTickets.updateTicket(ticket);
                /**/
            }
        });
    }
}

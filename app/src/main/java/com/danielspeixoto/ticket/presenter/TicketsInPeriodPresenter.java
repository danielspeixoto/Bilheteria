package com.danielspeixoto.ticket.presenter;

import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.helper.Time;
import com.danielspeixoto.ticket.model.CRUDTickets;
import com.danielspeixoto.ticket.model.pojo.Payment;
import com.danielspeixoto.ticket.model.pojo.Ticket;
import com.danielspeixoto.ticket.module.TicketsInPeriod;

import rx.Subscriber;

/**
 * Created by danielspeixoto on 2/21/17.
 */

public class TicketsInPeriodPresenter implements TicketsInPeriod.Presenter {

    private static float price;
    private static double total = 0;
    private TicketsInPeriod.View mView;
    private String startDate = Time.getDate(), endDate = startDate;

    public TicketsInPeriodPresenter(TicketsInPeriod.View view) {
        mView = view;
    }

    @Override
    public void setDates(String start, String end) {
        startDate = start;
        endDate = end;
    }

    @Override
    public void syncItems() {
        price = 0;
        total = 0;
        mView.reset();
        mView.setAmount(total);
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
                // TODO Fix this after corrections in users apps are made
                price = 0;
                for (Payment payment : ticket.getPayments()) {
                    price += payment.getAmount();
                }
                ticket.setPrice(price);
                CRUDTickets.updateTicket(ticket);
                mView.addItem(ticket);
                total += price;
                mView.setAmount(total);
            }
        });
    }
}

package com.danielspeixoto.ticket.presenter;

import com.danielspeixoto.ticket.model.CRUDTickets;
import com.danielspeixoto.ticket.model.pojo.Ticket;
import com.danielspeixoto.ticket.module.SearchTicket;

import rx.Subscriber;

/**
 * Created by danielspeixoto on 2/21/17.
 */

public class SearchTicketPresenter implements SearchTicket.Presenter {

    private SearchTicket.View mView;
    private String query;

    public SearchTicketPresenter(SearchTicket.View view) {
        mView = view;
    }

    @Override
    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public void syncItems() {
        if (query != null) {
            CRUDTickets.search(query).subscribe(new Subscriber<Ticket>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(Ticket ticket) {
                    mView.addItem(ticket);
                }
            });
        }
    }
}

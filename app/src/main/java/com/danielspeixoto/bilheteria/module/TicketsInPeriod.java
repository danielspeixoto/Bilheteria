package com.danielspeixoto.bilheteria.module;

import com.danielspeixoto.bilheteria.model.pojo.Ticket;

/**
 * Created by danielspeixoto on 2/21/17.
 */

public class TicketsInPeriod {

    public interface View extends Source.View<Ticket> {

        void setAmount(double amount);

        void reset();

    }

    public interface Presenter extends Source.Presenter {

        void setDates(String start, String end);

    }
}

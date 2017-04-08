package com.danielspeixoto.ticket.module;

/**
 * Created by danielspeixoto on 2/21/17.
 */

public class Reports {

    public interface View extends Base.View {

        //TODO This function will be sent continuously as it is updated, find way to send only once
        void setReport(com.danielspeixoto.ticket.model.Report report);

    }

    public interface Presenter extends Base.Presenter {

        void setDates(String start, String end);
        
        void getItems();
    }
}

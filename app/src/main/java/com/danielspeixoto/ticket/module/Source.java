package com.danielspeixoto.ticket.module;

/**
 * Created by danielspeixoto on 2/15/17.
 */

public class Source {

    public interface View<T> extends ActivityBase.View {

        void addItem(T t);

    }

    public interface Presenter extends ActivityBase.Presenter {

        void syncItems();

    }
}

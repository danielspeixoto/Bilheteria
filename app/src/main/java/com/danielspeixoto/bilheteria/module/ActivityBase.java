package com.danielspeixoto.bilheteria.module;

import com.danielspeixoto.bilheteria.view.BaseActivity;

/**
 * Created by danielspeixoto on 1/6/17.
 */

public class ActivityBase {

    public interface Presenter {

    }

    public interface View {

        BaseActivity getActivity();

        void goToActivity(Class clazz);
    }
}
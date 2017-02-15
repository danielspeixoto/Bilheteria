package com.danielspeixoto.bilheteria.module;

import com.danielspeixoto.bilheteria.view.activity.BaseActivity;

/**
 * Created by danielspeixoto on 1/6/17.
 */

public class ActivityBase {

    public interface View extends Base.View {

        BaseActivity getActivity();

        void goToActivity(Class clazz);
    }

    public interface Presenter extends Base.Presenter {

    }

}
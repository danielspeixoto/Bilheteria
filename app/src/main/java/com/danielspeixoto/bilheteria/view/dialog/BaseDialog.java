package com.danielspeixoto.bilheteria.view.dialog;

import android.app.Dialog;

import com.danielspeixoto.bilheteria.view.activity.BaseActivity;

import lombok.Getter;

/**
 * Created by danielspeixoto on 2/14/17.
 */

public abstract class BaseDialog extends Dialog {

    @Getter
    protected BaseActivity activity;

    public BaseDialog(BaseActivity activity) {
        super(activity);
        this.activity = activity;
    }

    public BaseDialog getDialog() {
        return this;
    }

}

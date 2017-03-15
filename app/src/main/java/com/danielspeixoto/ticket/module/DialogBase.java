package com.danielspeixoto.ticket.module;

import com.danielspeixoto.ticket.view.dialog.BaseDialog;

/**
 * Created by danielspeixoto on 1/8/17.
 */

public class DialogBase {

    public interface View extends Base.View {
        BaseDialog getDialog();
    }

    public interface Presenter extends Base.Presenter {

    }
}

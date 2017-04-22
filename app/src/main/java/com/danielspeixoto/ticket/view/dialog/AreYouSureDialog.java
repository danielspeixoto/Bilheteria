package com.danielspeixoto.ticket.view.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;

/**
 * Created by danielspeixoto on 18/11/16.
 */
public class AreYouSureDialog extends DialogFragment {

    public static final String TAG = "areYouSure";
    private Runnable mOnYesClicked;

    public AreYouSureDialog(Runnable mOnYesClicked) {
        this.mOnYesClicked = mOnYesClicked;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setTitle(App.getStringResource(R.string.are_you_sure))
                .setPositiveButton(App.getStringResource(R.string.yes), (dialog, which) -> mOnYesClicked.run())
                .setNegativeButton(App.getStringResource(R.string.no), null)
                .create();
    }
}

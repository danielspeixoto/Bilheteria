package com.danielspeixoto.ticket.view.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import com.danielspeixoto.ticket.R;

/**
 * Created by danielspeixoto on 18/11/16.
 */
public class AreYouSureDialog extends DialogFragment {

    public static final String TAG = "areYouSure";
    private Runnable mRunnable;

    public AreYouSureDialog(Runnable mRunnable) {
        this.mRunnable = mRunnable;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setTitle(R.string.are_you_sure)
                .setPositiveButton(R.string.yes, (dialog, which) -> mRunnable.run())
                .setNegativeButton(R.string.cancel, null)
                .create();
    }
}

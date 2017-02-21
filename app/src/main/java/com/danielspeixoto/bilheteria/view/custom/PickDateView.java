package com.danielspeixoto.bilheteria.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.danielspeixoto.bilheteria.helper.SimpleCallback;
import com.danielspeixoto.bilheteria.helper.Time;
import com.danielspeixoto.bilheteria.view.dialog.DateDialog;

/**
 * Created by danielspeixoto on 2/20/17.
 */

public class PickDateView extends LinearLayout {

    DateDialog startDialog, endDialog;
    private Context mContext;
    private SimpleCallback mCallback;

    public PickDateView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        startDialog = new DateDialog(mContext);
        endDialog = new DateDialog(mContext);
        setGravity(Gravity.CENTER_HORIZONTAL);
        setUp("Start Date");
        setUp("End Date");
    }

    public void setUp(String name) {
        LinearLayout linearLayout = new LinearLayout(mContext);
        linearLayout.setOrientation(VERTICAL);
        linearLayout.setPadding(32, 32, 32, 32);
        TextView textView = new TextView(mContext);
        textView.setText(Time.getFormat(Time.getDate(), Time.DD_MM_YYYY));
        textView.setTextSize(18);
        DateDialog dialog = name.equals("Start Date") ? startDialog : endDialog;
        dialog.setDate(Time.getDate());
        dialog.setMCallback(() -> {
            textView.setText(Time.getFormat(dialog.getDate(), Time.DD_MM_YYYY));
            mCallback.run();
        });
        Button button = new Button(mContext);
        button.setOnClickListener(v -> {
            dialog.show();
        });
        button.setText(name);
        button.setTextSize(18);
        button.setPadding(0, 0, 0, 16);
        linearLayout.addView(button);
        linearLayout.addView(textView);
        addView(linearLayout);
    }

    public String getStartDate() {
        return startDialog.getDate();
    }

    public String getEndDate() {
        return endDialog.getDate();
    }

    public void setOnPeriodChangedListener(SimpleCallback callback) {
        mCallback = callback;
    }
}

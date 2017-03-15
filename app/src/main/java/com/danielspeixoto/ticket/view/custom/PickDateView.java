package com.danielspeixoto.ticket.view.custom;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.SimpleCallback;
import com.danielspeixoto.ticket.helper.Time;
import com.danielspeixoto.ticket.view.dialog.DateDialog;

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
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER);
        setUp(getContext().getString(R.string.start_date));
        setUp(getContext().getString(R.string.end_date));
    }

    public void setUp(String name) {
        LinearLayout linearLayout = new LinearLayout(mContext);
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        linearLayout.setOrientation(VERTICAL);
        TextView textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setText(Time.getFormat(Time.getDate(), Time.DD_MM_YYYY));
        textView.setTextSize(18);
        textView.setPadding(0, 32, 0, 0);
        DateDialog dialog = name.equals(getContext().getString(R.string.start_date)) ? startDialog : endDialog;
        dialog.setDate(Time.getDate());
        dialog.setMCallback(() -> {
            textView.setText(Time.getFormat(dialog.getDate(), Time.DD_MM_YYYY));
            mCallback.run();
        });
        Button button = new Button(mContext);
        button.setOnClickListener(v -> {
            dialog.show();
        });
        button.setBackgroundColor(Color.WHITE);
        button.setPadding(32, 32, 32, 32);
        button.setText(name);
        button.setTextSize(18);
        linearLayout.setPadding(60, 16, 60, 16);
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

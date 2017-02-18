package com.danielspeixoto.bilheteria.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.danielspeixoto.bilheteria.helper.SimpleCallback;

/**
 * Created by danielspeixoto on 2/16/17.
 */

public class NumPicker extends LinearLayout {

    TextView amount;
    Button plus, minus;
    int lastValue = 0;
    private SimpleCallback mCallback;

    public NumPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(HORIZONTAL);
        amount = new TextView(context);
        amount.setText("0");
        amount.setTextSize(18);
        amount.setGravity(Gravity.CENTER);
        amount.setPadding(32, 0, 32, 0);
        minus = new Button(context);
        minus.setText("-");
        plus = new Button(context);
        plus.setText("+");
        setUpButton(plus);
        setUpButton(minus);
        addView(minus);
        addView(amount);
        addView(plus);
    }

    public void setUpButton(Button button) {
        button.setMinHeight(50);
        button.setMinWidth(50);
        button.setMinimumHeight(50);
        button.setMinimumWidth(50);

    }

    public void setOnAmountChanged(SimpleCallback callback) {
        mCallback = callback;
        minus.setOnClickListener(v -> {
            lastValue = getAmount();
            if (lastValue > 0) {
                amount.setText(String.valueOf(lastValue - 1));
                mCallback.run();
            }
        });
        plus.setOnClickListener(v -> {
            lastValue = getAmount();
            amount.setText(String.valueOf(lastValue + 1));
            mCallback.run();
        });
    }

    public int getAmount() {
        return Integer.valueOf(amount.getText().toString());
    }

    public int getAmountChanged() {
        return Integer.valueOf(amount.getText().toString()) - lastValue;
    }

    public void reset() {
        lastValue = 0;
        amount.setText("0");
    }


}

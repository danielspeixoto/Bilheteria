package com.danielspeixoto.bilheteria.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.danielspeixoto.bilheteria.helper.SimpleCallback;

import lombok.Getter;

/**
 * Created by danielspeixoto on 3/12/17.
 */

public class PickAmount extends LinearLayout {

    @Getter
    int amount = 0;
    TextView textView;
    SimpleCallback mCallback;

    public PickAmount(Context context, AttributeSet attrs) {
        super(context, attrs);
        // Text
        textView = new TextView(context);
        textView.setText("0");
        textView.setTextSize(24);
        textView.setPadding(24, 24, 24, 24);
        // Plus
        Button plus = new Button(context);
        plus.setOnClickListener(v -> {
            textView.setText(String.valueOf(++amount));
            mCallback.run();
        });
        plus.setLayoutParams(new LayoutParams(150, 150));
        plus.setText("+");
        // Minus
        Button minus = new Button(context);
        minus.setText("-");
        minus.setLayoutParams(new LayoutParams(150, 150));
        minus.setOnClickListener(v -> {
            if (amount > 0) {
                textView.setText(String.valueOf(--amount));
            }
            mCallback.run();
        });
        // Setting up
        setGravity(Gravity.CENTER);
        addView(minus, 0);
        addView(textView, 1);
        addView(plus, 2);
    }

    public void syncAmount(SimpleCallback callback) {
        mCallback = callback;
    }

    public void reset() {
        amount = 0;
        textView.setText("");
    }

}

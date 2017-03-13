package com.danielspeixoto.bilheteria.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;
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
        textView = new EditText(context);
        textView.setText("0");
        textView.setPadding(16, 16, 16, 16);
        Button plus = new Button(context);
        plus.setText("+");
        plus.setOnClickListener(v -> {
            textView.setText(String.valueOf(++amount));
            mCallback.run();
        });
        plus.setMinWidth(0);
        plus.setWidth(0);
        plus.setMinEms(0);
        Button minus = new Button(context);
        minus.setText("-");
        minus.setOnClickListener(v -> {
            if (amount > 0) {
                textView.setText(String.valueOf(--amount));
            }
            mCallback.run();
        });
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

package com.danielspeixoto.ticket.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.SimpleCallback;
import com.danielspeixoto.ticket.model.Connection;
import com.danielspeixoto.ticket.model.pojo.Permission;

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
        // Replace with R.dimen.text_important
        textView.setTextSize(18);
        textView.setPadding(36, 18, 36, 18);
        // Plus
        Button plus = new Button(context);
        plus.setOnClickListener(v -> {
            textView.setText(String.valueOf(++amount));
            mCallback.run();
        });
        plus.setLayoutParams(new LayoutParams(70, 70));
        plus.setBackgroundResource(R.drawable.ic_add_black_24dp);
        // Minus
        Button minus = new Button(context);
        minus.setBackgroundResource(R.drawable.ic_remove_black_24dp);
        minus.setLayoutParams(new LayoutParams(70, 70));
        minus.setOnClickListener(v -> {
            if (Connection.getCurrentUser().getPermissions().get(Permission.VIEW_HISTORY) || amount > 0) {
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
        textView.setText("0");
    }

}

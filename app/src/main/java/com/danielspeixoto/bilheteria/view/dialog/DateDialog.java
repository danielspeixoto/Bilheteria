package com.danielspeixoto.bilheteria.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.widget.DatePicker;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.helper.SimpleCallback;
import com.danielspeixoto.bilheteria.util.DateString;

import butterknife.BindView;
import butterknife.ButterKnife;
import lombok.Setter;

/**
 * Created by danielspeixoto on 1/7/17.
 */

public class DateDialog extends Dialog {

    @BindView(R.id.datePicker)
    DatePicker datePicker;

    @Setter
    SimpleCallback mCallback;

    public DateDialog(Context context) {
        super(context);
        this.setContentView(R.layout.date_dialog);
        ButterKnife.bind(this);
    }

    public String getDate() {
        String date = String.valueOf(datePicker.getYear()) + "-";
        date += datePicker.getMonth() > 8 ? (datePicker.getMonth() + 1) : "0" + (datePicker.getMonth() + 1);
        date += "-";
        date += datePicker.getDayOfMonth() > 9 ? datePicker.getDayOfMonth() : "0" + datePicker.getDayOfMonth();
        return date;
    }

    public void setDate(String date) {
        DateString dateString = new DateString(date);
        datePicker.updateDate(dateString.stringToYear(), dateString.stringToMonth() - 1, dateString.stringToDay());
    }

    @Override
    protected void onStop() {
        super.onStop();
        setDate(getDate());
        mCallback.run();
    }
}

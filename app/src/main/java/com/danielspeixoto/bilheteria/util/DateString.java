package com.danielspeixoto.bilheteria.util;

import lombok.Data;

/**
 * Created by danielspeixoto on 1/6/17.
 */

@Data
public class DateString {


    String date;

    public DateString(String date) {
        this.date = date;
    }

    public int stringToYear() {
        return Integer.valueOf(date.substring(0, 4));
    }

    public int stringToMonth() {
        return Integer.valueOf(date.substring(5, 7));
    }

    public int stringToDay() {
        return Integer.valueOf(date.substring(8));
    }

}

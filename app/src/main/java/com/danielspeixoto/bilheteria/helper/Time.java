package com.danielspeixoto.bilheteria.helper;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by danielspeixoto on 2/18/17.
 */

public class Time {

    public static long getToday() {
        return Date.valueOf(new Timestamp(System.currentTimeMillis()).toString().substring(0, 10)).getTime();
    }
}

package com.danielspeixoto.ticket.helper;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by danielspeixoto on 2/15/17.
 */

public class App extends Application {

    private static Context mContext;

    public static Context getContext() {
        return mContext;
    }

    public static String getStringResource(int resId) {
        return mContext.getString(resId);
    }

    public static void showMessage(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }
}

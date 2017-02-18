package com.danielspeixoto.bilheteria.view.recycler.holder;

import android.view.View;
import android.widget.TextView;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.view.activity.BaseActivity;
import com.danielspeixoto.bilheteria.view.activity.OffersActivity;
import com.danielspeixoto.bilheteria.view.activity.PaymentsActivity;
import com.danielspeixoto.bilheteria.view.recycler.adapter.BaseAdapter;

import butterknife.BindView;
import butterknife.OnClick;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by danielspeixoto on 05/12/16.
 */

public class DrawerHolder extends BaseHolder<BaseAdapter, String> {

    public static final int MANAGE_ITEMS = 2;
    public static final int MANAGE_PAYMENTS = 4;
    private final BaseActivity mActivity;
    @Setter
    protected int index;
    @BindView(R.id.drawer_text)
    @Getter
    TextView drawerText;

    public DrawerHolder(View itemView, BaseAdapter mAdapter) {
        super(itemView, mAdapter);
        mActivity = mAdapter.getActivity();
    }

    @Override
    public void onPostCreated() {

    }

    @OnClick(R.id.drawer_item)
    public void itemClicked() {
        switch (index) {
            case MANAGE_ITEMS:
                mActivity.goToActivity(OffersActivity.class);
                break;
            case MANAGE_PAYMENTS:
                mActivity.goToActivity(PaymentsActivity.class);
        }
    }

}

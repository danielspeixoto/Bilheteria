package com.danielspeixoto.bilheteria.view.recycler.holder;

import android.view.View;
import android.widget.TextView;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.view.activity.BaseActivity;
import com.danielspeixoto.bilheteria.view.activity.ItemsActivity;
import com.danielspeixoto.bilheteria.view.recycler.adapter.BaseRecyclerAdapter;

import butterknife.BindView;
import butterknife.OnClick;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by danielspeixoto on 05/12/16.
 */

public class DrawerHolder extends com.danielspeixoto.bilheteria.view.recycler.holder.BaseHolder {

    public static final int MANAGE_ITEMS = 2;
    private final BaseActivity mActivity;
    @Setter
    protected int index;
    @BindView(R.id.drawer_text)
    @Getter
    TextView drawerText;

    public DrawerHolder(View itemView, BaseRecyclerAdapter mAdapter) {
        super(itemView, mAdapter);
        mActivity = mAdapter.getActivity();
    }

    @OnClick(R.id.drawer_item)
    public void itemClicked() {
        switch (index) {
            case MANAGE_ITEMS:
                mActivity.goToActivity(ItemsActivity.class);
                break;
        }
    }

}

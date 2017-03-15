package com.danielspeixoto.ticket.view.recycler.holder;

import android.view.View;
import android.widget.TextView;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.model.pojo.Link;
import com.danielspeixoto.ticket.view.recycler.adapter.BaseAdapter;

import butterknife.BindView;
import butterknife.OnClick;
import lombok.Getter;

/**
 * Created by danielspeixoto on 05/12/16.
 */

public class DrawerHolder extends BaseHolder<BaseAdapter, Link> {

    @BindView(R.id.drawer_text)
    @Getter
    TextView drawerText;

    public DrawerHolder(View itemView, BaseAdapter mAdapter) {
        super(itemView, mAdapter);
    }

    @Override
    public void onPostCreated() {
        drawerText.setText(mItem.getName());
    }

    @OnClick(R.id.drawer_item)
    public void itemClicked() {
        mItem.getCallback().run();
    }

}

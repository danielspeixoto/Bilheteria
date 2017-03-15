package com.danielspeixoto.ticket.view.recycler.holder;

import android.view.View;
import android.widget.TextView;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.model.pojo.User;
import com.danielspeixoto.ticket.view.recycler.adapter.UserAdapter;

import butterknife.BindView;

/**
 * Created by danielspeixoto on 3/13/17.
 */

public class UserHolder extends BaseHolder<UserAdapter, User> {

    @BindView(R.id.nameText)
    TextView nameText;

    public UserHolder(View itemView, UserAdapter mAdapter) {
        super(itemView, mAdapter);
    }

    @Override
    public void onPostCreated() {
        nameText.setText(mItem.getName());
    }
}

package com.danielspeixoto.bilheteria.view.recycler.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.model.pojo.User;
import com.danielspeixoto.bilheteria.module.Source;
import com.danielspeixoto.bilheteria.view.activity.BaseActivity;
import com.danielspeixoto.bilheteria.view.recycler.holder.UserHolder;

/**
 * Created by danielspeixoto on 3/13/17.
 */

public class UserAdapter extends SourceAdapter<User, UserHolder, Source.Presenter> implements Source.View<User> {

    public UserAdapter(BaseActivity activity) {
        super(activity);
    }

    @Override
    public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_user, parent, false), this);
    }

    @Override
    public void reset() {
    }
}

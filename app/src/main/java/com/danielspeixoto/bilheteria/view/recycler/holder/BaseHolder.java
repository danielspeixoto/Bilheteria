package com.danielspeixoto.bilheteria.view.recycler.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.danielspeixoto.bilheteria.view.recycler.adapter.BaseAdapter;

import butterknife.ButterKnife;
import lombok.Setter;

/**
 * Created by danielspeixoto on 20/11/16.
 */
public abstract class BaseHolder<T extends BaseAdapter, S> extends RecyclerView.ViewHolder {

    protected static final String EMPTY_STRING = "";

    protected T mAdapter;
    @Setter
    protected S mItem;

    public BaseHolder(View itemView, T mAdapter) {
        super(itemView);
        this.mAdapter = mAdapter;
        ButterKnife.bind(this, itemView);
    }

    protected boolean checkTextEmpty(EditText editText) {
        return editText.getText().toString().equals(EMPTY_STRING);
    }

    protected String getText(EditText editText) {
        return editText.getText().toString();
    }

    public abstract void onPostCreated();

    protected void clear(EditText editText) {
        editText.setText(EMPTY_STRING);
    }
}

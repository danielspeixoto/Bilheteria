package com.danielspeixoto.bilheteria.view.recycler.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.danielspeixoto.bilheteria.view.activity.BaseActivity;
import com.danielspeixoto.bilheteria.view.recycler.holder.BaseHolder;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by danielspeixoto on 17/11/16.
 */
public abstract class BaseAdapter<T, S extends BaseHolder<? extends BaseAdapter, T>> extends RecyclerView.Adapter<S> {

    @Getter
    protected BaseActivity activity;
    @Getter
    @Setter
    protected ArrayList<T> data = new ArrayList<>();

    public BaseAdapter(BaseActivity activity) {
        this.activity = activity;
    }

    public void addItem(T t) {
        data.add(t);
        notifyDataSetChanged();
    }

    public abstract void getItems();

    @Override
    public void onBindViewHolder(S holder, int position) {
        holder.setMItem(data.get(position));
        holder.setPosition(position);
        holder.onPostCreated();
    }

    @Override
    public abstract S onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void goToActivity(Class clazz) {
        getActivity().goToActivity(clazz);
    }
}

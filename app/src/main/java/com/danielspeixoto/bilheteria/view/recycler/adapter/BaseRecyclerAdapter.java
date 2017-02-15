package com.danielspeixoto.bilheteria.view.recycler.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.danielspeixoto.bilheteria.view.activity.BaseActivity;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by danielspeixoto on 17/11/16.
 */
public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @Getter
    protected BaseActivity activity;
    @Getter
    @Setter
    protected ArrayList<T> data = new ArrayList<>();

    public BaseRecyclerAdapter(BaseActivity activity) {
        this.activity = activity;
    }

    public void addItem(T t) {
        data.add(t);
        notifyDataSetChanged();
    }

    public abstract void getItems();

    @Override
    public abstract void onBindViewHolder(RecyclerView.ViewHolder holder, int position);

    @Override
    public abstract RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void goToActivity(Class clazz) {
        getActivity().goToActivity(clazz);
    }
}

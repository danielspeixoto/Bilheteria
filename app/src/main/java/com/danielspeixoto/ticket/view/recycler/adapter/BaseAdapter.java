package com.danielspeixoto.ticket.view.recycler.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.danielspeixoto.ticket.view.activity.BaseActivity;
import com.danielspeixoto.ticket.view.recycler.holder.BaseHolder;

import java.util.ArrayList;
import java.util.Iterator;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by danielspeixoto on 17/11/16.
 */
public abstract class BaseAdapter<T, S extends BaseHolder<? extends BaseAdapter, T>>
		extends RecyclerView.Adapter<S> {

    @Getter
    protected BaseActivity activity;
    @Getter
    @Setter
    private ArrayList<T> data = new ArrayList<>();
    protected RecyclerView mRecyclerView;

    public BaseAdapter(BaseActivity activity) {
        this.activity = activity;
    }

    // It's public because it is used in interfaces
    public void addItem(T t) {
        data.add(t);
        notifyDataSetChanged();
    }
	
	@Override
	public void onAttachedToRecyclerView(RecyclerView recyclerView) {
		super.onAttachedToRecyclerView(recyclerView);
		mRecyclerView = recyclerView;
	}
	
	protected final T getItem(int position) {
        return data.get(position);
    }
    
    protected final void removeItem(int position) {
        data.remove(position);
        notifyDataSetChanged();
    }
    
    protected final void clearData() {
        data.clear();
        notifyDataSetChanged();
    }
    
    @NonNull
    protected final Iterator<T> getIterator() {
        return data.iterator();
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

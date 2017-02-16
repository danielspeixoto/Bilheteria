package com.danielspeixoto.bilheteria.view.recycler.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.model.pojo.ItemInfo;
import com.danielspeixoto.bilheteria.view.activity.BaseActivity;
import com.danielspeixoto.bilheteria.view.recycler.holder.ItemHolder;

/**
 * Created by danielspeixoto on 2/16/17.
 */

public class ItemsRecyclerAdapter<T extends ItemInfo> extends SourceRecyclerAdapter<T> {

    public ItemsRecyclerAdapter(BaseActivity activity) {
        super(activity);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemHolder itemHolder = (ItemHolder) holder;
        T item = data.get(position);
        itemHolder.setId(item.getUid());
        itemHolder.getNameText().setText(item.getName());
        itemHolder.getPriceText().setText("$" + item.getPrice());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item_info, parent, false), this);
    }
}

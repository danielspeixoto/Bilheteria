package com.danielspeixoto.bilheteria.view.recycler.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.helper.FloatCallback;
import com.danielspeixoto.bilheteria.model.pojo.ItemInfo;
import com.danielspeixoto.bilheteria.view.activity.BaseActivity;
import com.danielspeixoto.bilheteria.view.recycler.holder.ItemBuyHolder;

/**
 * Created by danielspeixoto on 2/16/17.
 */

public class ItemsBuyRecyclerAdapter extends ItemsRecyclerAdapter<ItemInfo> {

    private FloatCallback mCallback;

    public ItemsBuyRecyclerAdapter(BaseActivity activity, FloatCallback callback) {
        super(activity);
        mCallback = callback;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        ItemBuyHolder buyHolder = (ItemBuyHolder) holder;
        buyHolder.setMItem(data.get(position));
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemBuyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item_buy, parent, false), this);
    }

    public void updatePrice(float value) {
        mCallback.run(value);
    }
}

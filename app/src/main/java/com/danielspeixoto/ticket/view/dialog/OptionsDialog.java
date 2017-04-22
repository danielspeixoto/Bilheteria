package com.danielspeixoto.ticket.view.dialog;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.model.pojo.Link;
import com.danielspeixoto.ticket.view.activity.BaseActivity;
import com.danielspeixoto.ticket.view.custom.RecyclerList;
import com.danielspeixoto.ticket.view.recycler.adapter.OptionsAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by danielspeixoto on 4/11/17.
 */

public class OptionsDialog extends BaseDialog {

    @BindView(R.id.list)
    RecyclerList list;
    private OptionsAdapter mAdapter;

    public OptionsDialog(BaseActivity activity) {
        super(activity);
        this.setContentView(R.layout.options_dialog);
        ButterKnife.bind(this);
        mAdapter = new OptionsAdapter(activity);
        list.setAdapter(mAdapter);
    }

    public void setLinks(ArrayList<Link> links) {
        mAdapter.setData(links);
    }
}
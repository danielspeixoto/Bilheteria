package com.danielspeixoto.ticket.view.recycler.holder;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.model.pojo.Link;
import com.danielspeixoto.ticket.model.pojo.User;
import com.danielspeixoto.ticket.module.DeleteUser;
import com.danielspeixoto.ticket.presenter.DeleteUserPresenter;
import com.danielspeixoto.ticket.view.dialog.AreYouSureDialog;
import com.danielspeixoto.ticket.view.dialog.OptionsDialog;
import com.danielspeixoto.ticket.view.recycler.adapter.UsersAdapter;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by danielspeixoto on 3/13/17.
 */

public class UserHolder extends BaseHolder<UsersAdapter, User> implements DeleteUser.View {
    
    @BindView(R.id.nameText)
    TextView nameText;
	@BindView(R.id.cardItem)
	CardView cardItem;
    
    public UserHolder(View itemView, UsersAdapter mAdapter) {
        super(itemView, mAdapter);
        OptionsDialog dialog = new OptionsDialog(getActivity());
        ArrayList<Link> links = new ArrayList<>();
        // DELETE USER
        links.add(new Link(App.getStringResource(R.string.delete), () -> {
            AreYouSureDialog areYouSureDialog = new AreYouSureDialog(() -> new DeleteUserPresenter(UserHolder.this).delete(mItem));
            areYouSureDialog.show(getActivity().getSupportFragmentManager(), AreYouSureDialog.TAG);
            dialog.dismiss();
        }));
	    // EDIT USER
	    links.add(new Link(App.getStringResource(R.string.edit), () -> {
		    // User edit activity
	    }));
        dialog.setLinks(links);
        cardItem.setOnLongClickListener((l) -> {
            dialog.show();
            return true;
        });
    }
    
    @Override
    public void onDeleted() {
        mAdapter.getItems();
    }

	
    @Override
    public void onPostCreated() {
        nameText.setText(mItem.getName());
    }
}

package com.danielspeixoto.ticket.view.recycler.holder;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;
import com.danielspeixoto.ticket.model.pojo.Link;
import com.danielspeixoto.ticket.model.pojo.User;
import com.danielspeixoto.ticket.module.DeleteUser;
import com.danielspeixoto.ticket.presenter.DeleteUserPresenter;
import com.danielspeixoto.ticket.view.activity.UpdateUserActivity;
import com.danielspeixoto.ticket.view.dialog.AreYouSureDialog;
import com.danielspeixoto.ticket.view.dialog.OptionsDialog;
import com.danielspeixoto.ticket.view.recycler.adapter.UsersAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by danielspeixoto on 3/13/17.
 */

public class UserHolder extends BaseHolder<UsersAdapter, User> implements DeleteUser.View {
    
    @BindView(R.id.nameText)
    TextView nameText;

	private OptionsDialog dialog;
    
    public UserHolder(View itemView, UsersAdapter mAdapter) {
        super(itemView, mAdapter);
        dialog = new OptionsDialog(getActivity());
        ArrayList<Link> links = new ArrayList<>();
	    // EDIT USER
	    links.add(new Link(App.getStringResource(R.string.edit), () -> {
		    Intent intent = new Intent(getActivity(), UpdateUserActivity.class);
		    intent.putExtra(User.class.getSimpleName(), mItem);
		    getActivity().startActivity(intent);
	    }));
        // DELETE USER
        links.add(new Link(App.getStringResource(R.string.delete), () -> {
            AreYouSureDialog areYouSureDialog = new AreYouSureDialog(() -> new DeleteUserPresenter(UserHolder.this).delete(mItem));
            areYouSureDialog.show(getActivity().getSupportFragmentManager(), AreYouSureDialog.TAG);
            dialog.dismiss();
        }));
        dialog.setLinks(links);
    }
    
    @Override
    public void onDeleted() {
        mAdapter.getItems();
    }
    
    @OnClick(R.id.item)
    public void onItemClicked() {
	    dialog.show();
    }

	
    @Override
    public void onPostCreated() {
        nameText.setText(mItem.getName());
    }
}

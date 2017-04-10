package com.danielspeixoto.ticket.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.model.pojo.Ticket;
import com.danielspeixoto.ticket.module.OnItemChanged;
import com.danielspeixoto.ticket.presenter.ActivatedOffersPresenter;
import com.danielspeixoto.ticket.view.custom.RecyclerList;
import com.danielspeixoto.ticket.view.dialog.InfoDialog;
import com.danielspeixoto.ticket.view.recycler.adapter.OffersBuyAdapter;

import butterknife.BindView;
import butterknife.OnClick;

public class TicketDataActivity extends BaseActivity implements OnItemChanged<Float> {

    @BindView(R.id.idEdit)
    EditText idEdit;
    @BindView(R.id.observationsEdit)
    EditText observationsEdit;
    @BindView(R.id.offersList)
    RecyclerList offersList;
    @BindView(R.id.priceText)
    TextView priceText;
    private Ticket ticket = new Ticket();

    private OffersBuyAdapter mOffersAdapter = new OffersBuyAdapter(this, this);
    
    private final int REQUEST_PAY_TICKET = 1;
    private final String MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_ticket_data);
        activityInfo = getString(R.string.info_ticket_data);
        mOffersAdapter.setPresenter(new ActivatedOffersPresenter(mOffersAdapter));
        offersList.setNestedScrollEnabled(false);
        offersList.setAdapter(mOffersAdapter);
    }

    @OnClick(R.id.nextButton)
    public void goToPayActivity() {
        if (mOffersAdapter.getNotZero().size() == 0) {
            showMessage(getString(R.string.must_buy_something));
        } else {
            ticket.setIdentification(getText(idEdit));
            ticket.setObservations(getText(observationsEdit));
            ticket.setOffers(mOffersAdapter.getNotZero());
            Intent intent = new Intent(TicketDataActivity.this, PayTicketActivity.class);
            intent.putExtra(Ticket.class.getSimpleName(), ticket);
            startActivityForResult(intent, REQUEST_PAY_TICKET);
        }
    }
    
    public void onSuccess(String message) {
        clear();
        InfoDialog dialog = new InfoDialog(this);
        dialog.setInfoText(message);
        dialog.show();
    }

    public void clear() {
        clear(idEdit);
        clear(observationsEdit);
        idEdit.requestFocus();
        mOffersAdapter.reset();
        priceText.setText("$0.0");
    }
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK) {
			switch (requestCode) {
				case REQUEST_PAY_TICKET:
					onSuccess(data.getStringExtra(MESSAGE));
					break;
			}
		}
	}
	
	@Override
    public void onItemChanged(Float valueChanged) {
        priceText.setText("$" + (Float.valueOf(priceText.getText().toString().substring(1)) + valueChanged));
    }
}

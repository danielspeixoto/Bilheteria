package com.danielspeixoto.ticket.view.dialog;

import android.widget.EditText;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.model.pojo.Offer;
import com.danielspeixoto.ticket.module.CreateUpdateOffer;
import com.danielspeixoto.ticket.view.activity.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lombok.Setter;

/**
 * Created by danielspeixoto on 2/14/17.
 */

public class OfferDialog extends BaseDialog {

    @BindView(R.id.nameEdit)
    EditText nameEdit;
    @BindView(R.id.priceEdit)
    EditText priceEdit;
    Offer mOffer = new Offer();
    @Setter
    private CreateUpdateOffer.Presenter mPresenter;

    public OfferDialog(BaseActivity activity) {
        super(activity);
        this.setContentView(R.layout.offer_dialog);
        ButterKnife.bind(this);
    }
    
    public void setOffer(Offer mOffer) {
        this.mOffer = mOffer;
        nameEdit.setText(mOffer.getName());
        priceEdit.setText(String.valueOf(mOffer.getPrice()));
    }
    
    @OnClick(R.id.nextButton)
    public void save() {
        mOffer.setPrice(priceEdit.getText().toString().equals("") ? 0 : Float.valueOf(priceEdit.getText().toString()));
        mOffer.setName(nameEdit.getText().toString().trim());
        mPresenter.save(mOffer);
        dismiss();
    }
}

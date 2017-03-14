package com.danielspeixoto.bilheteria.view.dialog;

import android.widget.EditText;

import com.danielspeixoto.bilheteria.R;
import com.danielspeixoto.bilheteria.model.pojo.Offer;
import com.danielspeixoto.bilheteria.module.CRUDOffer;
import com.danielspeixoto.bilheteria.module.InsertOffer;
import com.danielspeixoto.bilheteria.view.activity.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lombok.Setter;

/**
 * Created by danielspeixoto on 2/14/17.
 */

public class OfferDialog extends BaseDialog implements InsertOffer.View {

    @BindView(R.id.nameEdit)
    EditText nameEdit;
    @BindView(R.id.priceEdit)
    EditText priceEdit;
    @Setter
    private CRUDOffer.Presenter mPresenter;

    public OfferDialog(BaseActivity activity) {
        super(activity);
        this.setContentView(R.layout.offer_dialog);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.saveButton)
    public void save() {
        float amount = priceEdit.getText().toString().equals("") ? 0 : Float.valueOf(priceEdit.getText().toString());
        mPresenter.save(new Offer(nameEdit.getText().toString(), amount));
    }
}

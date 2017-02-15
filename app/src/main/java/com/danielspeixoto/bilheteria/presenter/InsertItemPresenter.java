package com.danielspeixoto.bilheteria.presenter;

import com.danielspeixoto.bilheteria.model.CRUDItems;
import com.danielspeixoto.bilheteria.model.pojo.ItemInfo;
import com.danielspeixoto.bilheteria.module.InsertItem;
import com.danielspeixoto.bilheteria.util.Validate;

/**
 * Created by danielspeixoto on 2/14/17.
 */

public class InsertItemPresenter implements InsertItem.Presenter {

    private InsertItem.View mView;

    public InsertItemPresenter(InsertItem.View mView) {
        this.mView = mView;
    }

    @Override
    public void save(ItemInfo item) {
        String result = Validate.Item(item);
        if (result.equals(Validate.OK)) {
            CRUDItems.insertItem(item);
            result = "Item has been added";
            mView.getDialog().dismiss();
        }
        mView.getDialog().getActivity().showMessage(result);
    }
}

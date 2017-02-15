package com.danielspeixoto.bilheteria.module;

import com.danielspeixoto.bilheteria.model.pojo.ItemInfo;

/**
 * Created by danielspeixoto on 2/14/17.
 */

public class CRUDItem {

    public interface View extends DialogBase.View {

    }

    public interface Presenter extends DialogBase.Presenter {
        void save(ItemInfo item);
    }

}

package com.danielspeixoto.ticket.model.pojo;

import com.danielspeixoto.ticket.R;
import com.danielspeixoto.ticket.helper.App;

import lombok.Data;

/**
 * Created by danielspeixoto on 3/13/17.
 */

@Data
public class Permission {
    
    public static final String MANAGE_TICKET = "MANAGE_TICKET",
            MANAGE_USERS = "MANAGE_USERS",
            VIEW_HISTORY = "VIEW_HISTORY",
            MANAGE_OFFERS = "MANAGE_OFFERS",
            MANAGE_PAYMENT = "MANAGE_PAYMENT";

    public static final String FILTER_ONLY = "FILTER_ONLY";
    public static final String SELL = "SELL";
	
	public static final String MANAGE_TICKET_DEPRECATED = App.getStringResource(R.string.manage_tickets),
			MANAGE_USERS_DEPRECATED = App.getStringResource(R.string.manage_users),
			VIEW_HISTORY_DEPRECATED = App.getStringResource(R.string.history),
			MANAGE_OFFERS_DEPRECATED = App.getStringResource(R.string.manage_offers),
			MANAGE_PAYMENT_DEPRECATED = App.getStringResource(R.string.manage_payment);
    
    String name;
    String localeName;
    boolean isAllowed = false;

    public Permission(String name, boolean isAllowed) {
        this.name = name;
        setLocaleName(name);
        this.isAllowed = isAllowed;
    }
    
    public void setLocaleName(String name) {
        switch (name) {
            case MANAGE_TICKET :
                this.localeName = App.getStringResource(R.string.manage_tickets);
                break;
            case MANAGE_USERS :
                this.localeName = App.getStringResource(R.string.manage_users);
                break;
            case VIEW_HISTORY :
                this.localeName = App.getStringResource(R.string.history);
                break;
            case MANAGE_OFFERS :
                this.localeName = App.getStringResource(R.string.manage_offers);
                break;
            case MANAGE_PAYMENT :
                this.localeName = App.getStringResource(R.string.manage_payment);
                break;
            case FILTER_ONLY:
                this.localeName = App.getStringResource(R.string.filter_only);
                break;
            case SELL:
                this.localeName = App.getStringResource(R.string.sell);
                break;
        }
    }
}

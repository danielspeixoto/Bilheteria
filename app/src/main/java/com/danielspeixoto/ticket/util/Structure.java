package com.danielspeixoto.ticket.util;

import com.danielspeixoto.ticket.helper.Permissions;
import com.danielspeixoto.ticket.model.pojo.User;

import java.util.HashMap;

/**
 * Created by danielspeixoto on 4/7/17.
 */

public class Structure {
	
	public static User User(User user) {
		// Issue #1 Permissions in different languages
		if(user.getPermissions().containsKey(Permissions.MANAGE_OFFERS_DEPRECATED)) {
			HashMap<String, Boolean> updatedPermissions = new HashMap<>();
			HashMap<String, Boolean> permissions = user.getPermissions();
			updatedPermissions.put(Permissions.MANAGE_TICKET,
					permissions.get(Permissions.MANAGE_TICKET_DEPRECATED));
			updatedPermissions.put(Permissions.MANAGE_USERS,
					permissions.get(Permissions.MANAGE_USERS_DEPRECATED));
			updatedPermissions.put(Permissions.VIEW_HISTORY,
					permissions.get(Permissions.VIEW_HISTORY_DEPRECATED));
			updatedPermissions.put(Permissions.MANAGE_OFFERS,
					permissions.get(Permissions.MANAGE_OFFERS_DEPRECATED));
			updatedPermissions.put(Permissions.MANAGE_PAYMENT,
					permissions.get(Permissions.MANAGE_PAYMENT_DEPRECATED));
			user.setPermissions(updatedPermissions);
		}
		return user;
	}
}

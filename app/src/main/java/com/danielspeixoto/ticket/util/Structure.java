package com.danielspeixoto.ticket.util;

import com.danielspeixoto.ticket.model.pojo.Permission;
import com.danielspeixoto.ticket.model.pojo.User;

import java.util.HashMap;

/**
 * Created by danielspeixoto on 4/7/17.
 */

public class Structure {
	
	public static User User(User user) {
		// Issue #1 Permissions in different languages
		if(user.getPermissions().containsKey(Permission.MANAGE_OFFERS_DEPRECATED)) {
			HashMap<String, Boolean> updatedPermissions = new HashMap<>();
			HashMap<String, Boolean> permissions = user.getPermissions();
			updatedPermissions.put(Permission.MANAGE_TICKET,
					permissions.get(Permission.MANAGE_TICKET_DEPRECATED));
			updatedPermissions.put(Permission.MANAGE_USERS,
					permissions.get(Permission.MANAGE_USERS_DEPRECATED));
			updatedPermissions.put(Permission.VIEW_HISTORY,
					permissions.get(Permission.VIEW_HISTORY_DEPRECATED));
			updatedPermissions.put(Permission.MANAGE_OFFERS,
					permissions.get(Permission.MANAGE_OFFERS_DEPRECATED));
			updatedPermissions.put(Permission.MANAGE_PAYMENT,
					permissions.get(Permission.MANAGE_PAYMENT_DEPRECATED));
			user.setPermissions(updatedPermissions);
		}
		return user;
	}
}

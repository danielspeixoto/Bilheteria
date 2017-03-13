package com.danielspeixoto.bilheteria.helper;

import com.danielspeixoto.bilheteria.model.pojo.Permission;

import java.util.ArrayList;
import java.util.HashMap;

import lombok.Getter;

/**
 * Created by danielspeixoto on 3/13/17.
 */

public class Permissions {

    public static final String MANAGE_TICKET = "Manage Ticket", MANAGE_USERS = "Manage Users",
            VIEW_HISTORY = "View History", MANAGE_OFFERS = "Manage Offers", MANAGE_PAYMENT = "Manage Payment";

    public static final ArrayList<String> permissions = new ArrayList<>();
    @Getter
    public static final HashMap<String, Boolean> permissionsHash = new HashMap<>();

    static {
        permissions.add(MANAGE_TICKET);
        permissions.add(MANAGE_USERS);
        permissions.add(VIEW_HISTORY);
        permissions.add(MANAGE_OFFERS);
        permissions.add(MANAGE_PAYMENT);
        for (String string : permissions) {
            permissionsHash.put(string, false);
        }
    }


    public static HashMap<String, Boolean> getPermissions(ArrayList<Permission> permissions) {
        HashMap<String, Boolean> hashMap = new HashMap<>();
        for (Permission permission : permissions) {
            hashMap.put(permission.getName(), permission.isAllowed());
        }
        return hashMap;
    }

    public static HashMap<String, Boolean> getADMPermissions() {
        HashMap<String, Boolean> hashMap = new HashMap<>();
        for (String string : permissions) {
            hashMap.put(string, true);
        }
        return hashMap;
    }

    public static ArrayList<Permission> getPermissionsList() {
        ArrayList<Permission> permissionsList = new ArrayList() {
        };
        for (String string : permissions) {
            permissionsList.add(new Permission(string, false));
        }
        return permissionsList;
    }
}

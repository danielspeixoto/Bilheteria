package com.danielspeixoto.ticket.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

/**
 * Created by danielspeixoto on 2/14/17.
 */

@Data
public class User implements Parcelable {
	
    private HashMap<String, Boolean> permissions = new HashMap<>();
    private String name, username, password, adm;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String name, String username, String password, String adm, HashMap<String, Boolean> permissions) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.adm = adm;
        this.permissions = permissions;

    }
    
    protected User(Parcel in) {
        name = in.readString();
        username = in.readString();
        password = in.readString();
        adm = in.readString();
        int size = in.readInt();
        for(int i = 0; i < size; i++) {
            permissions.put(in.readString(), in.readByte() == 1);
        }
    }
    
    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }
        
        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
    
    @Override
    public int describeContents() {
        return 0;
    }
    
    @Override
    public void writeToParcel(Parcel dest, int flags) {
    
        dest.writeString(name);
        dest.writeString(username);
        dest.writeString(password);
        dest.writeString(adm);
	    dest.writeInt(permissions.size());
	    for(Map.Entry<String,Boolean> entry : permissions.entrySet()){
		    dest.writeString(entry.getKey());
		    dest.writeByte((byte)(entry.getValue() ? 1 : 0));
	    }
    }

    public boolean hasFilter() {
        if(username.equals(adm)) {
            return false;
        }
        if (this.permissions.containsKey(Permission.FILTER_ONLY)) {
            return ((Boolean) this.permissions.get(Permission.FILTER_ONLY)).booleanValue();
        }
        return false;
    }

    public boolean cannotSell() {
        if (!this.permissions.containsKey(Permission.SELL)) {
            return false;
        }
        if (((Boolean) this.permissions.get(Permission.SELL)).booleanValue()) {
            return false;
        }
        return true;
    }
}

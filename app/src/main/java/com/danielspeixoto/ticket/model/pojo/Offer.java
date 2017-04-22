package com.danielspeixoto.ticket.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import lombok.Data;

/**
 * Created by danielspeixoto on 2/14/17.
 */

@Data
public class Offer extends DatabaseItem implements Parcelable {

    public static final String IS_ACTIVATED = "activated";
    
    private float price;
    private int amount = 0;
    private boolean isActivated = true;

    public Offer() {

    }

    public Offer(String name, float price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public Offer(String name, float price) {
        this.name = name;
        this.price = price;
    }
    
    protected Offer(Parcel in) {
        uid = in.readString();
        name = in.readString();
        price = in.readFloat();
        amount = in.readInt();
        isActivated = in.readByte() != 0;
    }
    
    public static final Creator<Offer> CREATOR = new Creator<Offer>() {
        @Override
        public Offer createFromParcel(Parcel in) {
            return new Offer(in);
        }
        
        @Override
        public Offer[] newArray(int size) {
            return new Offer[size];
        }
    };
    
    public void changeAmount(int variation) {
        amount += variation;
    }

    public void toggleActivated() {
        isActivated = !isActivated;
    }
    
    @Override
    public int describeContents() {
        return 0;
    }
    
    @Override
    public void writeToParcel(Parcel dest, int flags) {
    
        dest.writeString(uid);
        dest.writeString(name);
        dest.writeFloat(price);
        dest.writeInt(amount);
        dest.writeByte((byte) (isActivated ? 1 : 0));
    }
}

package com.danielspeixoto.ticket.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import lombok.Data;

/**
 * Created by danielspeixoto on 2/14/17.
 */

@Data
public class Payment implements Parcelable {

    private String uid, name;
    private String observations;
    private float amount;

    public Payment() {

    }

    public Payment(String name) {
        this.name = name;
    }

    public Payment(String name, String observations, float amount) {
        this.name = name;
        this.observations = observations;
        this.amount = amount;
    }
    
    protected Payment(Parcel in) {
        uid = in.readString();
        name = in.readString();
        observations = in.readString();
        amount = in.readFloat();
    }
    
    public static final Creator<Payment> CREATOR = new Creator<Payment>() {
        @Override
        public Payment createFromParcel(Parcel in) {
            return new Payment(in);
        }
        
        @Override
        public Payment[] newArray(int size) {
            return new Payment[size];
        }
    };
    
    @Override
    public int describeContents() {
        return 0;
    }
    
    @Override
    public void writeToParcel(Parcel dest, int flags) {
    
        dest.writeString(uid);
        dest.writeString(name);
        dest.writeString(observations);
        dest.writeFloat(amount);
    }
}

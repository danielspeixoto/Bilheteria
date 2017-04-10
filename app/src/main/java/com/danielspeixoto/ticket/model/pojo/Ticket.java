package com.danielspeixoto.ticket.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

import lombok.Data;

/**
 * Created by danielspeixoto on 2/14/17.
 */
@Data
public class Ticket implements Parcelable{

    private String uid, identification, observations, seller;
    private long timestamp;
    private List<Offer> offers;
    private List<Payment> payments;
    private Float price;

    public Ticket(String identification, String observations, String seller, long timestamp, List<Offer> offers, List<Payment> payments) {
        this.identification = identification;
        this.observations = observations;
        this.seller = seller;
        this.timestamp = timestamp;
        setOffers(offers);
        this.payments = payments;
    }

    public Ticket() {
    }
    
    protected Ticket(Parcel in) {
        uid = in.readString();
        identification = in.readString();
        observations = in.readString();
        seller = in.readString();
        timestamp = in.readLong();
        offers = in.createTypedArrayList(Offer.CREATOR);
        payments = in.createTypedArrayList(Payment.CREATOR);
        if (in.readByte() == 0) {
            price = null;
        } else {
            price = in.readFloat();
        }
    }
    
    public static final Creator<Ticket> CREATOR = new Creator<Ticket>() {
        @Override
        public Ticket createFromParcel(Parcel in) {
            return new Ticket(in);
        }
        
        @Override
        public Ticket[] newArray(int size) {
            return new Ticket[size];
        }
    };
    
    public void setOffers(List<Offer> offers) {
	    float amount = 0;
	    for (Offer offer : offers) {
		    amount += offer.getAmount() * offer.getPrice();
	    }
	    setPrice(amount);
	    this.offers = offers;
    }
    
    @Override
    public int describeContents() {
        return 0;
    }
    
    @Override
    public void writeToParcel(Parcel dest, int flags) {
    
        dest.writeString(uid);
        dest.writeString(identification);
        dest.writeString(observations);
        dest.writeString(seller);
        dest.writeLong(timestamp);
        dest.writeTypedList(offers);
        dest.writeTypedList(payments);
        if (price == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(price);
        }
    }
}

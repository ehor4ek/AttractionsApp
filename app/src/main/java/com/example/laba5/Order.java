package com.example.laba5;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Order implements Parcelable {
    private Firm orderFirm;
    private Pack orderPack;
    private String orderFrom;
    private String orderTo;
    private int price;

    private boolean box = false;
    public static final Creator<Order> CREATOR = new Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel source) {
            Firm orderFirm = (Firm) source.readValue(getClass().getClassLoader());
            Pack orderPack = (Pack) source.readValue(getClass().getClassLoader());
            String orderFrom = source.readString();
            String orderTo = source.readString();
            int price = source.readInt();
            return new Order(orderFirm, orderPack, orderFrom, orderTo, price);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };
    Order(Firm orderFirm, Pack orderPack, String orderFrom, String orderTo, int price) {
        this.orderFirm = orderFirm;
        this.orderPack = orderPack;
        this.orderFrom = orderFrom;
        this.orderTo = orderTo;
        this.price = price;
    }

    public Firm getOrderFirm() {
        return orderFirm;
    }

    public Pack getOrderPack() {
        return orderPack;
    }

    public String getOrderTo() {
        return orderTo;
    }

    public String getOrderFrom() {
        return orderFrom;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        if (orderPack.getRequirement().equals("")) return "Маленькая";
        if (orderPack.getRequirement().equals("Нужна машина")) return "Большая";
        return "Документы";
    }

    public String getSize() {
        return orderPack.getSize();
    }

    public boolean sizable(int a, int b, int c) {
        return (orderPack.sizable(a, b, c));
    }

    public void setBox(boolean box) {
        this.box = box;
    }

    public boolean getBox() {
        return box;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeValue(orderFirm);
        parcel.writeValue(orderPack);
        parcel.writeString(orderFrom);
        parcel.writeString(orderTo);
        parcel.writeInt(price);
    }

    @Override
    public String toString() {
        return orderFirm.toString() +
        orderPack.toString() +
        orderFrom.toString() +
        orderTo.toString() +
        price + "\n\n";
    }
}
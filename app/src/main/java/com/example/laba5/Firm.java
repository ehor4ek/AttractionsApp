package com.example.laba5;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Firm implements Parcelable {
    private String address;
    private String name;
    public static final Creator<Firm> CREATOR = new Creator<Firm>() {
        @Override
        public Firm createFromParcel(Parcel source) {
            String address = source.readString();
            String name = source.readString();
            return new Firm(address, name);
        }

        @Override
        public Firm[] newArray(int size) {
            return new Firm[size];
        }
    };
    Firm(String address, String name) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(address);
        parcel.writeString(name);
    }
}

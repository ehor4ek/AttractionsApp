package com.example.laba5;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public class PackBig extends Pack implements Parcelable {
    double weight;
    PackBig(boolean fragility, String sizes) {
        super(fragility, sizes, "Нужна машина");
    }

    public static final Creator<PackBig> CREATOR = new Creator<PackBig>() {
        @RequiresApi(api = Build.VERSION_CODES.Q)
        @Override
        public PackBig createFromParcel(Parcel in) {
            boolean fragility = in.readBoolean();
            String sizes = in.readString();
            return new PackBig(fragility, sizes);
        }

        @Override
        public PackBig[] newArray(int size) {
            return new PackBig[size];
        }
    };

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeBoolean(this.getFragility());
        parcel.writeString(this.getSize());
    }
}
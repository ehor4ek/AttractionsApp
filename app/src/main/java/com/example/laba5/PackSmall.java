package com.example.laba5;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public class PackSmall extends Pack implements Parcelable {
    PackSmall(boolean fragility, String sizes) {
        super(fragility, sizes);
    }

    public static final Creator<PackSmall> CREATOR = new Creator<PackSmall>() {
        @RequiresApi(api = Build.VERSION_CODES.Q)
        @Override
        public PackSmall createFromParcel(Parcel in) {
            boolean fragility = in.readBoolean();
            String sizes = in.readString();
            return new PackSmall(fragility, sizes);
        }

        @Override
        public PackSmall[] newArray(int size) {
            return new PackSmall[size];
        }
    };

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

package com.example.laba5;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public class PackDoc extends Pack implements Parcelable {
    private String signment;

    public String getSignment() {
        return signment;
    }

    PackDoc(boolean fragility, String sizes, String requirement, String signment) {
        super(fragility, sizes, requirement);
        this.signment = signment;
    }

    public static final Creator<PackDoc> CREATOR = new Creator<PackDoc>() {
        @RequiresApi(api = Build.VERSION_CODES.Q)
        @Override
        public PackDoc createFromParcel(Parcel source) {
            boolean fragility = source.readBoolean();
            String sizes = source.readString();
            String requirement = source.readString();
            String signment = source.readString();
            return new PackDoc(fragility, sizes, requirement, signment);
        }

        @Override
        public PackDoc[] newArray(int size) {
            return new PackDoc[size];
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
        parcel.writeString(this.getRequirement());
        parcel.writeString(this.getSignment());
    }
}

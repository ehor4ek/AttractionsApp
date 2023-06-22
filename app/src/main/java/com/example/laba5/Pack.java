package com.example.laba5;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class Pack {
    private boolean fragility;
    private String requirement = "";
    private int x, y, z;

    Pack(boolean fragility, String sizes) {
        this.fragility = fragility;
        String[] size = sizes.split("x");
        x = Integer.parseInt(size[0]);
        y = Integer.parseInt(size[1]);
        z = Integer.parseInt(size[2]);
        int r;
        if (x > y) {
            r = x;
            x = y;
            y = r;
        }
        if (y > z) {
            r = y;
            y = z;
            z = r;
        }
        if (x > y) {
            r = x;
            x = y;
            y = r;
        }
    }
    Pack(boolean fragility, String sizes, String requirement) {
        this.fragility = fragility;
        String[] size = sizes.split("x");
        int r;
        x = Integer.parseInt(size[0]);
        y = Integer.parseInt(size[1]);
        z = Integer.parseInt(size[2]);
        this.requirement = requirement;
        if (x > y) {
            r = x;
            x = y;
            y = r;
        }
        if (y > z) {
            r = y;
            y = z;
            z = r;
        }
        if (x > y) {
            r = x;
            x = y;
            y = r;
        }
    }

    public String getSize() {
        return x + "x" + y + "x" + z;
    }

    public boolean sizable(int a, int b, int c) {
        return (x <= a && y <= b && z <= c);
    }

    public String getRequirement() {
        return requirement;
    }
    public boolean getFragility() {
        return fragility;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getZ() {
        return z;
    }
}

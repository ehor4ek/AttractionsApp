package com.example.laba5;

public abstract class Pack {
    private boolean fragility;
    private String requirement = "";
    private String size;
    Pack(boolean l, String s) {
        fragility = l;
        size = s;
    }
    Pack(boolean l, String s, String r) {
        fragility = l;
        size = s;
        requirement = r;
    }

    public String getRequirement() {
        return requirement;
    }
}

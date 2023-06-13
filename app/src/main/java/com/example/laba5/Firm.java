package com.example.laba5;

public class Firm {
    private String address;
    private String name;
    Firm(String address, String name) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }
}

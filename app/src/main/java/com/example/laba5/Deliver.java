package com.example.laba5;

import java.util.ArrayList;

public class Deliver {
    private String name;
    private String account;
    private String capabilities;
    private ArrayList<Order> deliverOrders = new ArrayList<Order>();
    Deliver(String name, String account, String capabilities) {
        this.name = name;
        this.account = account;
        this.capabilities = capabilities;
    }
    public void addOrder(Order order) {
        deliverOrders.add(order);
    }
    public String getName() {
        return name;
    }
    public String getAccount() {
        return account;
    }
    public String getCapabilities() {
        return capabilities;
    }
}
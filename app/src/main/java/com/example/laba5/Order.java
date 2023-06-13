package com.example.laba5;

public class Order {
    private Firm orderFirm;
    private Pack orderPack;
    private String orderFrom;
    private String orderTo;
    private int price;

    private boolean box = false;
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

    public void setBox(boolean box) {
        this.box = box;
    }

    public boolean getBox() {
        return box;
    }
}
package com.example.supermarketfx.Classes;

import java.sql.Connection;

public class Product {
    private String name;
    private int price;
    private int quantity;
    private Barcode barcode = new Barcode();

    public Product(String name, int price, int quantity, int code) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        barcode.setBarcode(code);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBarcode() {
        return barcode.getBarcode();
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

package com.example.cb;

public class Product {

    private String name;
    private String gtin;

    public Product(String name, String gtin) {
        this.name = name;
        this.gtin = gtin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGtin() {
        return gtin;
    }

    public void setGtin(String gtin) {
        this.gtin = gtin;
    }
}

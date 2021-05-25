package com.example.cb;

public class Product {

    private String name;
    private String gtin;
    private String date;

    public Product(String name, String gtin, String date) {
        this.name = name;
        this.gtin = gtin;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public boolean same(Product product)
    {
        return product.getDate() == this.getDate();
    }
}

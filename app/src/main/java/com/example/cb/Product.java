package com.example.cb;

public class Product {

    private String name;
    private String gtin;
    private String date;
    private String type;
    private int sum = 0;

    public Product(String name, String gtin, String date, String type) {
        this.name = name;
        this.gtin = gtin;
        this.date = date;
        this.type = type;
        this.sum = Integer.parseInt(date.substring(0, 2)) + (Integer.parseInt(date.substring(3, 5)) * 31) + (Integer.parseInt(date.substring(6, 10)) * 365);
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

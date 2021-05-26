package com.example.cb;

public class Product {

    // Attribute for a Product object
    // gtin used as a string to be easily passed between newProduct activity and MainActivity
    private String name;
    private String gtin;
    private String date;
    private String type;
    private int sum = 0;

    // Constructor
    public Product(String name, String gtin, String date, String type) {
        this.name = name;
        this.gtin = gtin;
        this.date = date;
        this.type = type;
        // sum represent the total number of days passed since 00-00-0000. Used to sort product to show products which will expire soon
        this.sum = Integer.parseInt(date.substring(0, 2)) + (Integer.parseInt(date.substring(3, 5)) * 31) + (Integer.parseInt(date.substring(6, 10)) * 365);
    }

    //------------- Getters and Setters ------------------//

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getType() {
        return type;
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

}

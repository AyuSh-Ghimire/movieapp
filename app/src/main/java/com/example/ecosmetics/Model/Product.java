package com.example.ecosmetics.Model;

public class Product {
    private String productname;
    private String productdesc;
    private int rate;
    private int productimg;

    public Product(String productname, String productdesc, int rate, int productimg) {
        this.productname = productname;
        this.productdesc = productdesc;
        this.rate = rate;
        this.productimg = productimg;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductdesc() {
        return productdesc;
    }

    public void setProductdesc(String productdesc) {
        this.productdesc = productdesc;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getProductimg() {
        return productimg;
    }

    public void setProductimg(int productimg) {
        this.productimg = productimg;
    }
}
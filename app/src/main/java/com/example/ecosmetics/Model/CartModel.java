package com.example.ecosmetics.Model;

public class CartModel {
    private String usercart;
    private String productcart;

    public CartModel(String usercart, String productcart) {
        this.usercart = usercart;
        this.productcart = productcart;
    }

    public String getUsercart() {
        return usercart;
    }

    public void setUsercart(String usercart) {
        this.usercart = usercart;
    }

    public String getProductcart() {
        return productcart;
    }

    public void setProductcart(String productcart) {
        this.productcart = productcart;
    }
}

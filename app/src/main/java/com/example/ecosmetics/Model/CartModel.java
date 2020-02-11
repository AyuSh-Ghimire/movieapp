package com.example.ecosmetics.Model;

public class CartModel {
    private String usercart;
    private String productcart;
    private String cproductdescp;
    private String cproductrate;
    private String quantity;
    private String cproductimg;


    public CartModel(String usercart, String productcart) {
        this.usercart = usercart;
        this.productcart = productcart;
    }

    public CartModel(String productcart, String cproductdescp, String cproductrate, String quantity, String cproductimg) {
        this.productcart = productcart;
        this.cproductdescp = cproductdescp;
        this.cproductrate = cproductrate;
        this.quantity = quantity;
        this.cproductimg = cproductimg;
    }

    public String getCproductdescp() {
        return cproductdescp;
    }

    public void setCproductdescp(String cproductdescp) {
        this.cproductdescp = cproductdescp;
    }

    public String getCproductrate() {
        return cproductrate;
    }

    public void setCproductrate(String cproductrate) {
        this.cproductrate = cproductrate;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCproductimg() {
        return cproductimg;
    }

    public void setCproductimg(String cproductimg) {
        this.cproductimg = cproductimg;
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

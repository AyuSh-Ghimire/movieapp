package com.example.Movie.Model;

public class CartModel {
    private User usercart;
    private Product productcart;
    private int quantity;

    public CartModel(User usercart, Product productcart, int quantity) {
        this.usercart = usercart;
        this.productcart = productcart;
        this.quantity = quantity;
    }

    public User getUsercart() {
        return usercart;
    }

    public void setUsercart(User usercart) {
        this.usercart = usercart;
    }

    public Product getProductcart() {
        return productcart;
    }

    public void setProductcart(Product productcart) {
        this.productcart = productcart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
